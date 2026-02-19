package com.scaler.productservicenamanbhallafeb24.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.springframework.data.repository.cdi.Eager;

/*
currently below we are creating PRODUCT class as per the attributes mentioned in
fakestoreapi.com/docs
 */
@Getter //Getter BTS creates get method for all the attributes
@Setter //Setter BTS creates set method for all the attributes
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {
    //private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
        /*
        Here i hv used fetch = FetchType.EAGER because, here Category is a single object, not a list of objects
        that is why we can eagerly load it without degrading our query performance
say, in json i am returning an object of Product and in Product, there is also
a Category Object and in Category there is an object of List<Product>
that is why we need JSONignore in Category class
 */
    /*
    cascade simply says if something happens to product, what to do to the category of that product
CascadeType.PERSIST means
if someone is trying to save a new product and that product has a category that doesnot exist yet in my database
then first store that category and then store that product in database

CascadeType.REMOVE
means
if someone is trying to remove the product, that product is associated to a category, it says delete that category too
but that is a stupid idea
instead it makes sense in Category class, that if u are trying to remove a category
all thr products corresponding to this category should also get removed
     */
    private Category category;
    /*
    say below i want to store the quantity as well
    schema change, flyway init migration
    so we now need to create a schema migration file for that with a next version V2
     */
    private  int quantity;
}
