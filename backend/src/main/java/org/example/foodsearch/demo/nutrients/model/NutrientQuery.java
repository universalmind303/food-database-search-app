package org.example.foodsearch.demo.nutrients.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class NutrientQuery implements Serializable {
    
    private static final long serialVersionUID = 6023005135677077764L;

    @Size(max = 200)
    private final String ndbNumber;

    public NutrientQuery(@Size(max = 200) String ndbNumber) {

        this.ndbNumber = ndbNumber;
    }

    public String getNdbNumber() {

        return ndbNumber;
    }


}