/*
 Copyright (c) 2021

 All rights reserved.
 */
package com.kumbirai.rest.webservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * <p><b>Purpose:</b><br>
 * <br>
 *
 * <p><b>Title:</b> ExceptionDetails<br>
 * <br>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 * <br>
 */
@Data
@AllArgsConstructor
public class ExceptionDetails
{
    private Date timestamp;
    private String message;
    private String details;
}
