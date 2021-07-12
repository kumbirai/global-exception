/*
 Copyright (c) 2021

 All rights reserved.
 */
package com.kumbirai.rest.webservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * <p><b>Purpose:</b><br>
 * <br>
 *
 * <p><b>Title:</b> CustomizedResponseEntityExceptionHandler<br>
 * <br>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 * <br>
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    /**
     * Constructor:
     */
    public CustomizedResponseEntityExceptionHandler()
    {
        super();
    }

    /**
     * Purpose:<br>
     * <br>
     * handleAllExceptions<br>
     * <br>
     *
     * @param ex      -
     * @param request -
     * @return <br> <br>
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request)
    {
        return new ResponseEntity<>(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), new ExceptionDetails(new Date(), ex.getMessage(), request.getDescription(false))), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        return new ResponseEntity<>(new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), new ExceptionDetails(new Date(), "Validation Failed", ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(e -> String.format("%s->%s %s", e.getObjectName(), Arrays.asList(e.getCodes()), e.getDefaultMessage()))
                .collect(Collectors.toList())
                .toString())), HttpStatus.BAD_REQUEST);
    }
}
