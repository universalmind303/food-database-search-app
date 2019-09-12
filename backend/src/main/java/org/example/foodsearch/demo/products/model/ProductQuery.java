package org.example.foodsearch.demo.products.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class ProductQuery implements Serializable {
    
    private static final long serialVersionUID = 6023005135677077764L;

    @Size(max = 200)
    private final String queryString;

    public ProductQuery(@Size(max = 200) String queryString) {

        this.queryString = queryString;
    }

    public String getQueryString() {

        return queryString;
    }


}