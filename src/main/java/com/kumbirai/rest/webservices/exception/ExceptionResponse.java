/*
 Copyright (c) 2021

 All rights reserved.
 */
package com.kumbirai.rest.webservices.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p><b>Purpose:</b><br>
 * <br>
 *
 * <p><b>Title:</b> ExceptionResponse<br>
 * <br>
 *
 * @author Kumbirai 'Coach' Mundangepfupfu<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 * <br>
 * @date 20 May 2021<br>
 */
@Data
@AllArgsConstructor
public class ExceptionResponse
{
    int status;
    String reason;
    ExceptionDetails exception;
}
