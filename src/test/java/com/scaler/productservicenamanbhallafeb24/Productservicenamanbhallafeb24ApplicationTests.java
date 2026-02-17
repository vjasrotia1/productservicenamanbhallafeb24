package com.scaler.productservicenamanbhallafeb24;

import com.scaler.productservicenamanbhallafeb24.repositories.CategoryRepository;
import com.scaler.productservicenamanbhallafeb24.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Productservicenamanbhallafeb24ApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void contextLoads() {
    }
//practicing around with JPA queries, create this method in ProductRepository(say)
    //and run it here,similarly
    @Test
    void testingqueries(){
        //productRepository.findAllByTitle("Hello");
        productRepository.findById(1L);

    }


}
