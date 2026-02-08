package com.scaler.productservicenamanbhallafeb24.dtos;

import com.scaler.productservicenamanbhallafeb24.models.Category;
import com.scaler.productservicenamanbhallafeb24.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto {
    /*
    whenever i am going to receive a response to my request from fkstore
    the response is going to hv below params in line with params in fakestoreapi.com/docs
     */
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

    /*
    in case fakestore api category is an object and (not a string)
    eg
    "category" :{
    "id":5,
    "title":"mobiles",
    "description" :"smartphones and accessories"
    }

    so in place of private String category;
    we would be having private FakeStoreCategoryDto category;
    where
    public class FakeStoreCategoryDto{
    private Long id;
    private String title;
    private String description;
    //getters and setters
    }
     */

    /*
    toproduct() is the mapping method : The mapping method is the only place where two worlds are allowed to touch
     */
    public Product toproduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        //for us in the Product Object, is category a string ?? NO
        Category productcategory = new Category();
        productcategory.setTitle(category);
        product.setCategory(productcategory);
        return product;
    }

}
