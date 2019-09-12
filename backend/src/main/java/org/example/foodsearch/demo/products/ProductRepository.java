package org.example.foodsearch.demo.products;

import java.util.Collection;

import org.example.foodsearch.demo.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Collection<Product> findByProductNameContaining(String productQuery);
}