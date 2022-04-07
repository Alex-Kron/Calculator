package com.alexkron.calculator.exception;

public class DivisionByZeroException extends Exception{
    public DivisionByZeroException() {
        super("Division by zero is impossible for this calculator");
    }
}
