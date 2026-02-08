package com.scaler.productservicenamanbhallafeb24.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
this class is created in order to write a method which returns obj of REST template class
 */

@Configuration
//writing @configuration is just a way to tell spring that in this class there are some beans, i hv defined
public class ApplicationConfiguration {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
    /*
    now in any class if i need an object of rest template, i can use this object, example in case of fakestoreprodservice class
     */
}
