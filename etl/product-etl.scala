import org.apache.spark.sql.functions._

lazy val nutrientSourcesDF = spark.table("nutrimedy.nutrients")
lazy val servingSizeDF = spark.table("nutrimedy.serving_size")
lazy val productsDF = spark.table("nutrimedy.products")
  .withColumnRenamed("NDB_Number", "NDB_No")
  .select($"NDB_No", $"ingredients_english",  $"long_name".alias("product_name"))

lazy val joinColumn = "NDB_No"
lazy val joinType = "inner"

val joinedDF = productsDF
  .join(nutrientSourcesDF, Seq(joinColumn), joinType)
  .join(servingSizeDF, Seq(joinColumn), joinType)

val joinedAndCleanedDF = joinedDF.toDF(joinedDF.columns.map(_.toLowerCase): _*)

lazy val nutrientsDF = joinedAndCleanedDF.select(
  $"ndb_no",
  $"product_name",
  $"ingredients_english".alias("ingredients"), 
  concat($"nutrient_name", lit(": "), $"output_value", $"output_uom").alias("nutrient_info"), 
  concat($"serving_size", $"serving_size_uom").alias("serving_size"),
  concat($"household_serving_size".cast("Int"), lit(" "), $"household_serving_size_uom").alias("household_serving_size")
)

val nutrientInfoAggDF = nutrientsDF
  .groupBy("ndb_no")
  .agg(split(concat_ws(";",collect_list("nutrient_info")), ";").alias("nutrients_list"))

val nutrientsWithAggDF = nutrientInfoAggDF.join(nutrientsDF, Seq("ndb_no"), "inner")
val filteredDF = nutrientsWithAggDF.select($"ndb_no", $"nutrients_list", $"ingredients", $"household_serving_size", $"serving_size", $"product_name")
  .distinct
  .withColumn("id", monotonically_increasing_id)

val jdbcUrl = s"jdbc:postgresql://database-2.cvqj69k6hydl.us-east-1.rds.amazonaws.com:5432/nutrimedy?user=postgres&password=password"

val connectionProperties = new java.util.Properties()

filteredDF.distinct.write.mode(SaveMode.Overwrite).jdbc( 
  url=jdbcUrl, 
  table="products", 
  connectionProperties=connectionProperties
)
