package com.scaler.productservicenamanbhallafeb24.controllers;

/*purpose of product controller?
Cont. means Controller going forward
this cont. will be the first entry point where evry client will be sending the rquest
it will receive the request and pass it to the relevant server

how to tell spring boot, that this is controller class can receive the request
using @RESTController, this is how we can create a controller
 */

import com.scaler.productservicenamanbhallafeb24.models.Product;
import com.scaler.productservicenamanbhallafeb24.services.FakeStoreProductService;
import com.scaler.productservicenamanbhallafeb24.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

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

    public ProductController(ProductService productService) {
        this.productService = productService;
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
    public void createProduct(){

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
