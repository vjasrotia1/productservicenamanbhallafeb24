package com.scaler.productservicenamanbhallafeb24.controllers;

/*purpose of product controller?
Cont. means Controller going forward
this cont. will be the first entry point where evry client will be sending the rquest
it will receive the request and pass it to the relevant server

how to tell spring boot, that this is controller class can receive the request
using @RESTController, this is how we can create a controller
 */

import com.scaler.productservicenamanbhallafeb24.dtos.CreateProductRequestDto;
import com.scaler.productservicenamanbhallafeb24.models.Product;
import com.scaler.productservicenamanbhallafeb24.services.FakeStoreProductService;
import com.scaler.productservicenamanbhallafeb24.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {

    private RestTemplate restTemplate;


    //private ProductService productService;
//    now that we have created an interface called ProductService and both FakeStoreProductService and ownDatabaseProductService implementing
//       this interface, instead of writing above line, we wil write :

    /*
    below line private ProductService productService = new FakeStoreProductService();
    why we should not create an object of service within the class ??
    because it will lead to nonflexibility for future changes, we hv to make chnges at many places, which is not desirable
    problem of dependency injection
     */
    //private ProductService productService = new FakeStoreProductService();

    private ProductService productService   ;

    public ProductController(ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
        //this rest template obj is exactly same as the rest template obj which we just created in fkstoreprodservice class
        //as befire the start of application, spring created an object of Rest template and is now only injecting in other classes
        //as per our requirement
    }

//in this product cont. there will be many API(API ultimately call a function of controller)
    /*
    do we have to tell framework that below api i.e. createproduct creates a product --YES
    so we have annotate each function/API in controller
    like for eg.
    POST/products
    RequestBody
    {
    title:
    description:
    price :
    }

    i will hv to tell spring that client side will give above api(POST/products) alognwith RequestBody
please make this request come to method createProduct()

using
@PostMapping("/products")
spring knows that any (POST request) that comes to this server at (/products) endpoint from client/frontend, then please call

method createProduct()

similarly whenever a (GET request) comes at (/products) endpoint from client/FE, then call method getallProducts()
     */

    @PostMapping("/products")
    /*
    below in the method argument, we can read like : from the request body, i will receive CreateProductRequestDto requestDto

    if it would have been a user and not a product, would u have returned a user or userdto?
    backend would have returned a userdto as we donot want to expose all params of user like password
    but for product there is nothing confidential, so in below method we are returning a product, rather than product dto

    quesn - as seen below while your controller is receiving DTOs, should ur service be receiving input params as DTOs??
because in product service interface, to create a product, i need to give params, what should be the params in service

@RequestBody - This annotation should NOT be in service interfaces

“Hey Spring, the data for this parameter will come from the HTTP request body (JSON).
Please convert that JSON into a Java object for me.”

This is only meaningful in a controller, because only controllers deal with HTTP.
     */
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){

/*
when u are creating  a product u will need to know the attributes of the product. where will u know those attributes?
we will get that information about these attributes as part of a Request Body. i.e. title,description,price,category etc

which is the object that has all this info. ???
should my Controller request/response datatype depend on some 3rd party like fakestore ?? NO
so here we need to create a class of CreateProductRequestDTO
typically whenever ur request is going to receive Request Body,u create a DTO for that
so we will create class as CreateProductRequestDto

this createproduct method is going to work by calling the service, so in the productservice interface, let us
add another method as createproduct()
 */

return productService.createProduct(
        requestDto.getTitle(),
        requestDto.getImage(),
        requestDto.getDescription(),
        requestDto.getCategory(),
        requestDto.getPrice()
);
/*
can i run the post request from the browser directly?
NO, so i will open postman, go to post request localhost:8080/products
go to body and select raw and JSON, we create the json
and click on send button, we will see a new product created

so basically, what happend here
1.client send the request to server
2. server further sends the request to fakestore
3. fakestore gave this response back in form of json and we converted this json in fakestoreproductdto type and further
into Product Type using toproduct() methods


 */
    }
    /*
    here, below thru @GetMapping("/products/{id}"), i am telling spring that in the path of my request, there is a variable with
    name as "id", check the value of the variable name "id" and assign that value to the parameter productId
    in the argument of my function
    till now we have learned how to receive request from FE

     */

    /*
    now we will learn how to give response for a request,lets start with getProductDetails
    typically, what should be the response type when someone asks for  getproductdetails -- response in json format will be
    complicated
    --- show list of say 50 products

    so here we go, in spring boot, there is another benefit, we only deal only in terms of OBJECTS
    spring will handle the work of serialising and deserialsing
     */

@GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
        //once this is done, next thing is to implement function getsingleproduct(Long id) in fakestoreproductservice
        /*
        how will controller do its job?
        here we are getting product details from fakestore
        where will all the code of getting the details of a particular product present?  they will be present in Product Service
        and not in this particular method

        now the ques'n is : service that i will b implementing today, as today for all the work related to product, i am calling  fakestore api
        or we can say that today, we are using FAKESTORE api to implement all the functionalities, but tommorrow same work i will do via my own database

so i need to make sure that i dont have to make a lot  of changes in my code base as i move from fakestore implementation to database implementation
//  SOLUTION TO ABOVE IS INTERFACE, instead of having an attribute as private ProductService productservice

        CONTROLLER IS TALKING TO THE SERVICE
         */
    }

    @GetMapping("/products")
    public void getallProducts(){

    }
    public void updateProduct(Long productId){

    }


}
