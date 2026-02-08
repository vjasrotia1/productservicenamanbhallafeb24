package com.scaler.productservicenamanbhallafeb24.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
currently below we are creating PRODUCT class as per the attributes mentioned in
fakestoreapi.com/docs
 */
@Getter //Getter BTS creates get method for all the attributes
@Setter //Setter BTS creates set method for all the attributes
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;


}
