package org.example.foodsearch.demo.nutrients.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataproduct")
public class Nutrient implements Serializable {
    private static final long serialVersionUID = 602135135677077764L;

    @Id
    private Long id;

    @Column(name = "ndb_no")
    private String ndbNo;

    @Column(name = "long_name")
    private String longName;

    public Nutrient() {
    }

    public Nutrient(Long id, String longName, String ndbNo) {
        this.id = id;
        this.longName = longName;
        this.ndbNo = ndbNo;
    }

    public Long getId() {
        return id;
    }

    public String getLongName() {
        return longName;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", longName=" + longName + ", ndbNo=" + ndbNo + "]";
    }
}