package com.scaler.productservicenamanbhallafeb24;

import com.scaler.productservicenamanbhallafeb24.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
//@EnableJpaRepositories
}
/*
to maintain version history,i hv to install version history migration tool
i.e. flyway version tool
go to maven repository , search flyway and add dependency in pom.xml
also add flyway Mysql dependency
we are installing flyway as we want to start maintaining versions of DB
but at this moment we already hav some Tables in DB
 */

/*
currently redis is running on your local machine, by default your application
will be able to connect with it
but if u are running REDIS on a third party server say AWS, then we will need
to provide some configuration to your code/application regarding where your redis
is running and from where u hv to make/establish a connection

so we go to application properties

 */
