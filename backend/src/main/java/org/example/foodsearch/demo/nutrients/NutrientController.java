package org.example.foodsearch.demo.nutrients;

import java.io.IOException;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.example.foodsearch.demo.common.SearchFacet;
import org.example.foodsearch.demo.nutrients.model.Nutrient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class NutrientController {

    private final Logger log = LoggerFactory.getLogger(NutrientController.class);

    private NutrientService nutrientService;

    @Autowired
    public NutrientController(NutrientService nutrientService) {

        this.nutrientService = nutrientService;
    }

    @GetMapping
    public Stream<Nutrient> getNutrients(@Valid SearchFacet searchFacet) throws IOException {

        log.info("getNutrientsHit");
        
        return nutrientService.getNutrients(searchFacet);


    }
}