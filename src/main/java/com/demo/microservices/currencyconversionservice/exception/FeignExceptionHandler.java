package com.demo.microservices.currencyconversionservice.exception;

import feign.FeignException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest.class)  
    public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
        response.setStatus(e.status());
        return e.contentUTF8(); 
    }

}