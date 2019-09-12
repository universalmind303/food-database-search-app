package org.example.foodsearch.demo.nutrients.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "nutrients")
@TypeDefs(@TypeDef(name = "string-array", typeClass = StringArrayType.class))
public class Nutrient implements Serializable {

    private static final long serialVersionUID = 602132935677077764L;

    @Id
    private Long id;

    @Column(name = "ndb_no")
    private String ndbNo;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "nutrients_list")
    @Type(type = "string-array")
    private String[] nutrientsList;

    public Nutrient() {
    }

    public Nutrient(Long id, String ingredients, String[] nutrientsList, String ndbNo) {
        this.id = id;
        this.ingredients = ingredients;
        this.nutrientsList = nutrientsList;
        this.ndbNo = ndbNo;
    }

    public Long getId() {
        return id;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String[] getNutrientsList() {
        return nutrientsList;
    }

    public String getNdbNo() {
        return ndbNo;
    }

    @Override
    public String toString() {
        return "Nutrient [id=" + id + ", ingredients=" + ingredients + ", ndbNo=" + ndbNo + "]";
    }
}