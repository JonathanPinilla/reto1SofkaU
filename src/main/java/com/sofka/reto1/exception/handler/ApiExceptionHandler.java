package com.sofka.reto1.exception.handler;

import com.sofka.reto1.exception.BusinessException;
import com.sofka.reto1.exception.general.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            NotFoundException.class
    })
    @ResponseBody
    public Message notFoundRequest(HttpServletRequest request, Exception exception){
        return new Message(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BusinessException.class
    })
    @ResponseBody
    public Message badRequest(HttpServletRequest request, Exception exception){
        return new Message(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Message fatalErrorUnexpectedException(HttpServletRequest request, Exception exception){
        return new Message(exception, request.getRequestURI());
    }
}
