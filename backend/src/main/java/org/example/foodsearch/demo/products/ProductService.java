package org.example.foodsearch.demo.products;

import java.util.Collection;

import org.example.foodsearch.demo.products.model.Product;
import org.example.foodsearch.demo.products.model.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        
        this.productRepository = productRepository;
        
    }

    public Collection<Product> getProducts(ProductQuery query) {
        return productRepository.findByProductNameContaining(query.getQueryString());
    }
}