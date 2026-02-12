package com.scaler.productservicenamanbhallafeb24.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
/*
ErrorDto exists to future-proof and structure error responses
if u want to send more information regarding the error/exception to the client
we can accomodate those things in this dto
that is why it is importnt that we dont return raw primitives(string,int) from API for error/exceptions
 */
public class ErrorDto {
    private String errormessage;
    //private String errorcode;
    //private String errordescription;
    //private String path;
    //private LocalDateTime timestamp;

}
