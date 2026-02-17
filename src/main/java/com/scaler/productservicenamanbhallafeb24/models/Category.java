package com.scaler.productservicenamanbhallafeb24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel {
    //private Long id;
    private String title;
@OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
@JsonIgnore

//this @jsonignore tells jackson "don't serailise products when serialising a category"
//alternatively we could hv used @JsonManagedReference in Product class
//and @JsonBackReference in Category class
/*
    cascade simply says if somethign happens to category, what to do to the products of that category
    1. delete all products
    2. donot delete products, just set their category_id = null
    3.donot allow to delete the category

 */
    private List<Product> products;

}
