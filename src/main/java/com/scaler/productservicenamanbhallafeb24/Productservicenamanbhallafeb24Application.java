package com.scaler.productservicenamanbhallafeb24;

import com.scaler.productservicenamanbhallafeb24.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
in java, there could be classes like that have multiple variations i.e datatypes are not strict
e.g  class map<int,int> , class map<int,string> etc.
these classes are known as GENERIC clases and are handled using GENERICS in java

internally in java, they hv defined all the methods of such a GENERIC class based upon these GENERIC datatype

suppose we have

public class Map{
private String/int/char Key;
private String/int/char Value;

public  String/int/char(same as datatype of Value above) dosomething(String/int/char input----same as dataype of Key above)

return xyz; (datatype of return in this case will be same as datatype of Value above)

 */
@SpringBootApplication
public class Productservicenamanbhallafeb24Application {

    public static void main(String[] args) {

            //Product p=new Product();

        SpringApplication.run(Productservicenamanbhallafeb24Application.class, args);
    }

}
