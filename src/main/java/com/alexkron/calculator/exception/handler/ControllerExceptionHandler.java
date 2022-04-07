package com.alexkron.calculator.exception.handler;

import com.alexkron.calculator.exception.DivisionByZeroException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
    @ExceptionHandler({DivisionByZeroException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDivisionByZeroException(DivisionByZeroException e) {
        log.error("ExceptionHandler: DivisionByZeroException");
        return e.getMessage();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleConstraintViolationException(ConstraintViolationException e) {
        log.error("ExceptionHandler: ConstraintViolationException");
        return e.getLocalizedMessage();
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParameterException(MissingServletRequestParameterException e) {
        log.error("ExceptionHandler: MissingServletRequestParameterException");
        return "Parameters are missing in the request: " + e.getParameterName();
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleTyposException(MethodArgumentTypeMismatchException e) {
        log.error("ExceptionHandler: MethodArgumentTypeMismatchException");
        return "Typo in request parameter: " + e.getParameter().getParameter().getName();
    }
}
