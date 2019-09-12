package org.example.foodsearch.demo.nutrients;

import java.util.Collection;

import org.example.foodsearch.demo.nutrients.model.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutrientRepository extends JpaRepository<Nutrient, Long> {

    public Collection<Nutrient> findByNdbNo(String ndbNumber);

}