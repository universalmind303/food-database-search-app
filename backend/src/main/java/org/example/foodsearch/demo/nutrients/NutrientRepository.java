package org.example.foodsearch.demo.nutrients;

import java.util.stream.Stream;

import org.example.foodsearch.demo.nutrients.model.Nutrient;
import org.example.foodsearch.demo.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutrientRepository extends JpaRepository<Product, Long> {

    public Stream<Nutrient> findByLongNameContaining(String productQuery);
}