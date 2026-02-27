package com.scaler.productservicenamanbhallafeb24;

import com.scaler.productservicenamanbhallafeb24.models.Category;
import com.scaler.productservicenamanbhallafeb24.models.Product;
import com.scaler.productservicenamanbhallafeb24.repositories.CategoryRepository;
import com.scaler.productservicenamanbhallafeb24.repositories.ProductRepository;
import com.scaler.productservicenamanbhallafeb24.repositories.projections.ProductProjection;
import com.scaler.productservicenamanbhallafeb24.repositories.projections.ProductWithIdAndTitle;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Productservicenamanbhallafeb24ApplicationTests {

//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Test
//    void contextLoads() {
//    }
////practicing around with JPA queries, create this method in ProductRepository(say)
//    //and run it here,similarly
//    @Test
//    void testingqueries(){
//        //productRepository.findAllByTitle("Hello");
//        //productRepository.findById(1L);
//        //productRepository.findAllByCategory_titleIgnoreCase("hi tithi");
//        List<ProductProjection> products= productRepository.getTitlesOfProductsOfGivenCategory(
//                2L
//        );
//
//        //now let me debug this test case,by puttign a debug statement at the closing bracket of this testingqueries
//
//        System.out.println(products.get(0).getId());
//        System.out.println(products.get(0).getTitle());
//        System.out.println();
//        System.out.println(products.get(1).getId());
//        System.out.println(products.get(1).getTitle());
//        //u will be able to see things in console
//    }
//
//    //@Test
//    //here basically u just have to write some code which can insert some product in DB
////    void sampletestcase(){
////         Product product = new Product();
////         product.setCategory(new Category());
////         product.setCreatedAt();
////         productRepository.save(product);
////    }
//
//    @Test
//            void testingqueries2() {
//        Optional<Category> optionalCategory = categoryRepository.findById(4L);
//        Category category = optionalCategory.get();
//
///*
//by default when we fetch category object, List<Product> products attribute
// is set as lazy
// which means, by default there will be no joins
//
// */
//        //lets now put some debug points
//
//        //System.out.println("fetched the category object");
//        //till this point, no Join has happened since for List<Product> products
//        //in category object default fetch type is lazy loading. this can be seen in the SQL query when we
//        //run this testcase. bydefault JPA is fetching this category object in lazy manner
//        //JPA is not fetching Collection Object
//
//
//        // some code here
//        //some code here
//        //some code here
//            //I am commenting out line below because i hv set List<Product> products attribute in Category class
//        // Fetch Type as Eager Loading. earlier it was lazy loading so we hv to explicitly write another query to
//        //get list of products
//        //List<Product> products=optionalCategory.get().getProducts();
//        //another debug line
//
//        System.out.println("fetched the list of products from category object");
//
//        //instead  of running the test case completely, i will run it in debug mode
//
//        //when i am calling getProducts API, then only JPA should go to
//        //database and fetch the products using another query
//
//    }
}
