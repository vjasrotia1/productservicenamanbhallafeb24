package com.scaler.productservicenamanbhallafeb24.advices;


import com.scaler.productservicenamanbhallafeb24.dtos.ErrorDto;
import com.scaler.productservicenamanbhallafeb24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/*
i will completely remove the exception handler from product controller class
controller advice is a global advisor, it is checking the response of every service layer of each of the requests handled by each of the controller
so now if every controller,which results in ProductNotFoundException, response to client will be sent via this method below
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setErrormessage(productNotFoundException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorDto);
    }
}
