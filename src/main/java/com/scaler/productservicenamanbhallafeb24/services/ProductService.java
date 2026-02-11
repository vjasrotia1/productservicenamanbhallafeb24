package com.scaler.productservicenamanbhallafeb24.services;

import com.scaler.productservicenamanbhallafeb24.dtos.CreateProductRequestDto;
import com.scaler.productservicenamanbhallafeb24.models.Category;
import com.scaler.productservicenamanbhallafeb24.models.Product;

import java.util.List;

/*
no implementation in Interface
it is just a class having methods without implementation
 */
public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getProducts();
    List<Category> getCategories();

    Product updateProduct(Long productId, CreateProductRequestDto requestDto);
    Product PatchProduct(Long productId,CreateProductRequestDto requestDto);

    List<Product> getProductsByCategory(String categoryName);

    void deleteProduct(Long productId);
    /*
    in below function Product createProduct();
    if we do Product createProduct(CreateProductRequestDto requestDto); it would mean that a person is going to create a product
    only if the createProduct request comes
    what if there is another request called, say replace product
     */
    Product createProduct(String title,
                          String image,
                          String description,
                          String category,
                          Double price);
}
