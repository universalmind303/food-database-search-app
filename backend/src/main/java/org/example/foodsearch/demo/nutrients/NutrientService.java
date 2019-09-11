package org.example.foodsearch.demo.nutrients;

import java.util.stream.Stream;

import org.example.foodsearch.demo.common.SearchFacet;
import org.example.foodsearch.demo.nutrients.model.Nutrient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutrientService {

    private NutrientRepository nutrientRepository;

    @Autowired
    public NutrientService(NutrientRepository nutrientRepository) {
        this.nutrientRepository = nutrientRepository;
    }

    public Stream<Nutrient> getNutrients(SearchFacet searchFacet) {
        return nutrientRepository.findByLongNameContaining(searchFacet.getProductName()); 
    }
}