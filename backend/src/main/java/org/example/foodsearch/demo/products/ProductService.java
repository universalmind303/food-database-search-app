package org.example.foodsearch.demo.products;

import java.util.Collection;

import org.example.foodsearch.demo.common.SearchFacet;
import org.example.foodsearch.demo.products.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        
        this.productRepository = productRepository;
        
    }

    public Collection<Product> getProducts(SearchFacet searchFacet) {
        return productRepository.findByLongNameContaining(searchFacet.getProductName());
    }
}