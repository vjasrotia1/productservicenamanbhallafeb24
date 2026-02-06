package com.scaler.productservicenamanbhallafeb24.services;

import com.scaler.productservicenamanbhallafeb24.models.Product;

import java.util.List;

/*
no implementation in Interface
it is just a class having methods without implementation
 */
public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getProducts();
}
