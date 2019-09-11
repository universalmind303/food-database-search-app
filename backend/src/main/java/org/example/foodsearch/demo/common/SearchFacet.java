package org.example.foodsearch.demo.common;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class SearchFacet implements Serializable {
    
    private static final long serialVersionUID = 6023005135677077764L;

    @Size(max = 200)
    private final String productName;

    public SearchFacet(@Size(max = 200) String productName) {

        this.productName = productName;
    }

    public String getProductName() {

        return productName;
    }


}