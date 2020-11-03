package com.thoughtworks.capacity.gtb.mvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
        e.printStackTrace();
        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        return new Error(HttpStatus.BAD_REQUEST.value(), msg == null ? "请求参数不合法" : msg);
    }
}
