package com.alexkron.calculator.controller;

import com.alexkron.calculator.exception.DivisionByZeroException;
import com.alexkron.calculator.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping("/")
@Validated
@Tag(name = "Calculator controller", description = "The controller contains four basic mathematical operations: addition, subtraction, multiplication, division")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Operation(summary = "Addition of two numbers")
    @GetMapping("add/")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal add(@RequestParam("firstOperand")
                          @Digits(integer = 20, fraction = 10)
                          @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                  BigDecimal firstOperand,
                          @RequestParam("secondOperand")
                          @Digits(integer = 20, fraction = 10)
                          @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                  BigDecimal secondOperand) {
        log.debug("Controller: add(" + firstOperand + ", " + secondOperand + ")");
        return calculatorService.add(firstOperand, secondOperand);
    }

    @Operation(summary = "Subtract second number from first number")
    @GetMapping("subtract/")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal subtract(@RequestParam("firstOperand")
                               @Digits(integer = 20, fraction = 10)
                               @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                       BigDecimal firstOperand,
                               @RequestParam("secondOperand")
                               @Digits(integer = 20, fraction = 10)
                               @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                       BigDecimal secondOperand) {
        log.debug("Controller: subtract(" + firstOperand + ", " + secondOperand + ")");
        return calculatorService.subtract(firstOperand, secondOperand);
    }

    @Operation(summary = "Multiplication of two numbers")
    @GetMapping("multiply/")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal multiply(@RequestParam("firstOperand")
                               @Digits(integer = 20, fraction = 10)
                               @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                       BigDecimal firstOperand,
                               @RequestParam("secondOperand")
                               @Digits(integer = 20, fraction = 10)
                               @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                       BigDecimal secondOperand) {
        log.debug("Controller: multiply(" + firstOperand + ", " + secondOperand + ")");
        return calculatorService.multiply(firstOperand, secondOperand);
    }

    @Operation(summary = "Division of the first number by the second number")
    @GetMapping("divide/")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal divide(@RequestParam("firstOperand")
                             @Digits(integer = 20, fraction = 10)
                             @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                     BigDecimal firstOperand,
                             @RequestParam("secondOperand")
                             @Digits(integer = 20, fraction = 10)
                             @Parameter(required = true, allowEmptyValue = false, description = "Number limited to 20 integer characters and 10 fraction characters")
                                     BigDecimal secondOperand) throws DivisionByZeroException {
        log.debug("Controller: divide(" + firstOperand + ", " + secondOperand + ")");
        return calculatorService.divide(firstOperand, secondOperand);
    }
}
