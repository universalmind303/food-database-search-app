package org.example.foodsearch.demo.products;

import java.io.IOException;
import java.util.Collection;

import javax.validation.Valid;

import org.example.foodsearch.demo.common.SearchFacet;
import org.example.foodsearch.demo.products.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public Collection<Product> getProducts(@Valid SearchFacet searchFacet) throws IOException {

        log.info("getProductsHit");
        
        return productService.getProducts(searchFacet);


    }
}