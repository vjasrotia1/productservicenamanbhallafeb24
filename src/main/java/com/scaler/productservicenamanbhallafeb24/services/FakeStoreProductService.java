package com.scaler.productservicenamanbhallafeb24.services;

import com.scaler.productservicenamanbhallafeb24.dtos.CreateProductRequestDto;
import com.scaler.productservicenamanbhallafeb24.dtos.FakeStoreProductDto;
import com.scaler.productservicenamanbhallafeb24.models.Category;
import com.scaler.productservicenamanbhallafeb24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
/*
we will first implement getSingleProduct API,
very first thing i want to do is, i want to make an API call to fkstore URL, where it gives details of product
we go to fakestoreapi.com/docs, and find that we will hv to make a call to this API https://fakestoreapi.com/products/1'

how will i make this api call?
do i need to write code for making internet/web/socket connection?, setting up things on internet?
or asking  my OS to send an indirect request etc??  --- NO

this is where libraries/framework comes into picture

we will talk to a library called "REST Template"
this SPRINGBOOT STARTER WEB DEPENDENCY also comes with a class
called REST template

this class allows to send HTTPS requests to external API and get/work with the API responses
REST template is the defacto standard for calling to an external API
quesn - can there be multiple classes in my codebase that would want to make an API call to 3rd party


e.g. user service,product service,category service, etc
will single object of REST template work across for all services
or do i need to create multiple object of REST template class in each of these classes?

e.g. REST template.get(https://..../1)
e.g. REST template.get(https://..../2)
so on

different service class will be calling methods on that particular object with different params

REST template is a simple class, where there are multiple methods to make API request
all of the info tht u hv to use, is sent as a part of that method
means same obj of REST template will be enough

how to ensure that there is only 1 obj of REST template across the application?

this is again the use case of DEPENDENCY INJECTION
how?? SOLUTION
if we tell spring that this is a special class, spring will automatically create an obj of that class
and thn whenever/wherever, spring will automatically put that object there
so we will create an obj of REST template and tell spring that it is an important class so that spring can inject it at
other places
till now we were using annotation to mark a class as important

but that was possible if the class was written/created by us

However REST template class is already provided by default by Spring Web(importing that class so we cant edit it),so we cant annotate it

so here comes the concept of SPRING BEANS

what are spring beans ??
these are the objects that spring creates and puts it in its application context so as to be able to inject the object of
 that particular data type into anyother classes

e.g. when spring created an object of product controller(as we annotate it with @RESTController), that object became a bean

since REST template cant be annotated with @Service, so what is another way to create the bean?
just annotate a method that returns the object of what u want to put in application context as bean (in this case REST template)
so if we want the obj of REST template to be injectable by spring accross the Classes in application, just create a method
like :

@Bean -- now spring will also see the beans and store them in application context, before it actually starts the application
public RestTemplate doxyz(){
return new RestTemplate
}
for this as a good practice, we create a separate package as configs--application configuration class
 */
    @Override
    public Product getSingleProduct(Long productId) {
        //most critical part of rest template
       FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);
        /*
        via "https://fakestoreapi.com/products/" + productId, i will receive a json, and i will hav to convert this json
        into an object of what datatype?

        Product datatype?-- NO
        i will hv to create a DTO, since the attributes of product in fkstore and in the product model which i hv created
        will not be the same, so we will now create a DTO package

        i will tell my FKstoreprod service that, after making call to fkstore URL "https://fakestoreapi.com/products/" + productId,
        u will get a json
        convert this json into an object of FakeStoreProductDto.class and return an object

        in short, we are telling Rest Template here or using a Rest template here, that please make a API call to a fakestore API or URl
        by making a get request and when u GET a JSON response from that URL u are converting that response into an object of
        fakestoreproductDto class and now we can use this object at anyother place

        moving on, now my service needs to return an object of what datatype?

        PRODUCT
        so i need to convert obj of FakeStoreProductDto to obj of Product, but how??
        for this i will create another method in FakeStoreProductDto class

         */
        return fakeStoreProductDto.toproduct();
    }

    @Override
    public List<Product> getProducts() {
        FakeStoreProductDto[] fakeStoreProducts=restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<>();
//enhanced for loop means For every element inside fakeStoreProducts, give me one element at a time as a FakeStoreProductDto fakeStoreProductDto
//        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProducts){
//            products.add(fakeStoreProductDto.toproduct());
//         }
        for(int i=0; i<fakeStoreProducts.length; i++){
            FakeStoreProductDto fakeStoreProductDto=fakeStoreProducts[i];
            products.add(fakeStoreProductDto.toproduct());
        }
        return products;

        /*
        in above
        Manually fetch element at index i
        and then Convert FakeStore DTO → Product and add to list
         */
    }

    @Override
    public List<Category> getCategories() {
        String[] fakestorecategories=restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",String[].class);

        List<Category> categories=new ArrayList<>();
        for(String NameofCategory:fakestorecategories){
        Category category=new Category();
        category.setTitle(NameofCategory);
        categories.add(category);
    }
        return categories;
    }

    @Override
    public Product updateProduct(Long productId, CreateProductRequestDto requestDto) {
FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
fakeStoreProductDto.setCategory(requestDto.getCategory());
fakeStoreProductDto.setTitle(requestDto.getTitle());
fakeStoreProductDto.setPrice(requestDto.getPrice());
fakeStoreProductDto.setImage(requestDto.getImage());
fakeStoreProductDto.setDescription(requestDto.getDescription());

// FakeStore PUT does not return body → so we have to fetch the updated product
       restTemplate.put(
                "https://fakestoreapi.com/products/"+productId,fakeStoreProductDto
        );
FakeStoreProductDto updatedproduct=restTemplate.getForObject(
        "https://fakestoreapi.com/products/"+productId,FakeStoreProductDto.class
);
        return updatedproduct.toproduct();

        /*
        restTemplate.put(...)   // returns void, so u cannot assign it to a response as u are doing above
        CANT DO THIS
         FakeStoreProductDto response=restTemplate.put(
                "https://fakestoreapi.com/products/"+productId,FakeStoreProductDto fakeStoreProductDto
        );
         */
    }

    @Override
    public Product PatchProduct(Long productId, CreateProductRequestDto requestDto) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(requestDto.getCategory());
        fakeStoreProductDto.setTitle(requestDto.getTitle());
        fakeStoreProductDto.setPrice(requestDto.getPrice());
        fakeStoreProductDto.setImage(requestDto.getImage());
        fakeStoreProductDto.setDescription(requestDto.getDescription());

        FakeStoreProductDto patchedproduct=restTemplate.patchForObject(

                "https://fakestoreapi.com/products/"+productId,fakeStoreProductDto,FakeStoreProductDto.class
        );
        return patchedproduct.toproduct();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {

        FakeStoreProductDto[] fakestoreproductsByCategory = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/"+categoryName,FakeStoreProductDto[].class
        );
        List<Product> productsByCategory=new ArrayList<>();
        for(FakeStoreProductDto fakestoreproductDto:fakestoreproductsByCategory){
            productsByCategory.add(fakestoreproductDto.toproduct());
        }
        return productsByCategory;
    }

    @Override
    public void deleteProduct(Long productId) {
        restTemplate.delete(
                "https://fakestoreapi.com/products/"+productId
        );
    }


    @Override
    public Product createProduct(String title,
                                 String image,
                                 String description,
                                 String category,
                                 Double price) {

        /*
        at this place, i hv to send a request to fakestore api to create/add a new product.
        how am i going to implement it(create product) in my service??

        in fakestore add product we need to send below particular infor
        {
"id": 0,
"title": "string",
"price": 0.1,
"description": "string",
"category": "string",
"image": "http://example.com"
}
 */
FakeStoreProductDto fakeStoreProductDto= new FakeStoreProductDto();
fakeStoreProductDto.setTitle(title);
fakeStoreProductDto.setImage(image);
fakeStoreProductDto.setDescription(description);
fakeStoreProductDto.setCategory(category);
fakeStoreProductDto.setPrice(price);

FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto, FakeStoreProductDto.class);
        return response.toproduct();
    }
}
