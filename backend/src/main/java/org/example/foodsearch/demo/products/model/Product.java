package org.example.foodsearch.demo.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 602135135677077764L;

    @Id
    private Long id;

    @Column(name = "ndb_no")
    private String ndbNo;

    @Column(name = "product_name")
    private String productName;

    public Product() {
    }

    public Product(Long id, String productName, String ndbNo) {
        this.id = id;
        this.productName = productName;
        this.ndbNo = ndbNo;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName + ", ndbNo=" + ndbNo + "]";
    }
}