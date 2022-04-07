package com.alexkron.calculator.service;

import com.alexkron.calculator.exception.DivisionByZeroException;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal add(BigDecimal firstOperand, BigDecimal secondOperand);

    BigDecimal subtract(BigDecimal firstOperand, BigDecimal secondOperand);

    BigDecimal multiply(BigDecimal firstOperand, BigDecimal secondOperand);

    BigDecimal divide(BigDecimal firstOperand, BigDecimal secondOperand) throws DivisionByZeroException;
}
