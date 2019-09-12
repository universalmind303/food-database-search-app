package org.example.foodsearch.demo.nutrients;

import java.util.Collection;

import org.example.foodsearch.demo.nutrients.model.Nutrient;
import org.example.foodsearch.demo.nutrients.model.NutrientQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutrientService {

    private NutrientRepository nutrientRepository;

    @Autowired
    public NutrientService(NutrientRepository nutrientRepository) {
        this.nutrientRepository = nutrientRepository;
    }

    public Collection<Nutrient> getNutrients(NutrientQuery query) {
        Collection<Nutrient> info = nutrientRepository.findByNdbNo(query.getNdbNumber());

        return info;
    }
}