package org.example.foodsearch.demo.products;

import java.util.Collection;

import org.example.foodsearch.demo.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = 
    "SELECT product_name, id, nutrients_list, ingredients FROM  (\n" +
        "SELECT DISTINCT ON (product_name) * FROM products\n" +
    ") t\n" +
    "WHERE lower(product_name) LIKE concat('%', lower(:query), '%') \n" +
    "ORDER BY CASE\n" + 
        "WHEN lower(trim(product_name)) =  lower(:query) THEN 1\n" +
        "WHEN lower(product_name) LIKE lower(:query) THEN 2\n" +
        "WHEN lower(product_name) LIKE concat(lower(:query), '%') THEN 3\n" +
        "WHEN lower(product_name) LIKE concat('%', lower(:query)) THEN 4\n" +
        "ELSE 5\n" +
        "END ASC\n" +
    "LIMIT 20", nativeQuery = true)
    public Collection<Product> getProducts(@Param("query") String productQuery);
}