package com.alexkron.calculator.service;

import com.alexkron.calculator.exception.DivisionByZeroException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;

@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public BigDecimal add(BigDecimal firstOperand, BigDecimal secondOperand) {
        log.debug("Service: add(" + firstOperand + ", " + secondOperand + ")");
        return firstOperand.add(secondOperand, MathContext.DECIMAL128);
    }

    @Override
    public BigDecimal subtract(BigDecimal firstOperand, BigDecimal secondOperand) {
        log.debug("Service: subtract(" + firstOperand + ", " + secondOperand + ")");
        return firstOperand.subtract(secondOperand, MathContext.DECIMAL128);
    }

    @Override
    public BigDecimal multiply(BigDecimal firstOperand, BigDecimal secondOperand) {
        log.debug("Service: multiply(" + firstOperand + ", " + secondOperand + ")");
        return firstOperand.multiply(secondOperand, MathContext.DECIMAL128);
    }

    @Override
    public BigDecimal divide(BigDecimal firstOperand, BigDecimal secondOperand) throws DivisionByZeroException {
        try {
            log.debug("Service: divide(" + firstOperand + ", " + secondOperand + ")");
            return firstOperand.divide(secondOperand, MathContext.DECIMAL128);
        } catch (ArithmeticException e) {
            log.error("Service: divide(" + firstOperand + ", " + secondOperand + ") - An arithmetic error has been made");
            throw new DivisionByZeroException();
        }
    }
}
