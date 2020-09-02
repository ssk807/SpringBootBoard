package com.example.boarddemo.Contorller;

import com.example.boarddemo.Contorller.Exception.NoItemError;
import com.example.boarddemo.Contorller.Exception.PathFormatError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class PostExceptionController{

    @ExceptionHandler(NoSuchElementException.class)
    public @ResponseBody
    NoItemError noItemErrorHandler(NoSuchElementException e) {
        NoItemError noItemError = new NoItemError();
        noItemError.setMessage(e.getMessage());
        return noItemError;
    }

    @ExceptionHandler(NumberFormatException.class)
    public @ResponseBody
    PathFormatError pathFormatErrorHandler(NumberFormatException e) {
        PathFormatError pathFormatError = new PathFormatError();
        pathFormatError.setMessage(e.getMessage());
        return pathFormatError;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public @ResponseBody
    String duplicateKeyExceptionHandler(DuplicateKeyException e) {
        return e.getMessage();
    }
}
