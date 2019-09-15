package org.example.foodsearch.demo.nutrients;

import java.io.IOException;
import java.util.Collection;

import javax.validation.Valid;

import org.example.foodsearch.demo.nutrients.model.Nutrient;
import org.example.foodsearch.demo.nutrients.model.NutrientQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nutrients")
@CrossOrigin(origins = "http://localhost:3000")
public class NutrientController {

    private final Logger log = LoggerFactory.getLogger(NutrientController.class);

    private NutrientService nutrientService;

    @Autowired
    public NutrientController(NutrientService nutrientService) {

        this.nutrientService = nutrientService;
    }

    @GetMapping
    public Collection<Nutrient> getNutrients(@Valid NutrientQuery query) throws IOException {

        log.info("getNutrientsHit");

        return nutrientService.getNutrients(query);

    }
}