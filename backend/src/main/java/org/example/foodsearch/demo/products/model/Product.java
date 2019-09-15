package org.example.foodsearch.demo.products.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "products")
@TypeDefs(@TypeDef(name = "string-array", typeClass = StringArrayType.class))
public class Product implements Serializable {
    private static final long serialVersionUID = 602135135677077764L;

    @Id
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "nutrients_list")
    @Type(type = "string-array")
    private String[] nutrientsList;

    public Product() {
    }

    public Product(Long id, String productName, String ingredients, String[] nutrientsList) {

        this.id = id;
        this.productName = productName;
        this.ingredients = ingredients;
        this.nutrientsList = nutrientsList;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String[] getNutrientsList() {
        return nutrientsList;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", ingredients=" + ingredients + ", ndbNo=" + ndbNo + ", nutrientsList="
                + Arrays.toString(nutrientsList) + ", productName=" + productName + "]";
    }


}