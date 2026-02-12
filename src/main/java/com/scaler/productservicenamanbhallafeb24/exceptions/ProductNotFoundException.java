package com.scaler.productservicenamanbhallafeb24.exceptions;

/*
here below, i am literally saying

“Hey Exception, store this message inside yourself.”
and later on, i will do exception.getMessge() that returns this stored value
like
errorDto.SetErrormessage(exception.getMessage());
this exception here is of type ProductNotFoundException
 */
public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
