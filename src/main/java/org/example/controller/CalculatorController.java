package org.example.controller;

import org.example.exception.DivByZeroException;
import org.example.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1,
                       @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Проверить правильность передаваемых параметров";
        }
        return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1,
                        @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Проверить правильность передаваемых параметров";
        }
        return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1,
                           @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Проверить правильность передаваемых параметров";
        }
        return num1 + " x " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1,
                         @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Проверить правильность передаваемых параметров";
        }

        return num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }

    @ExceptionHandler(DivByZeroException.class)
    public String handleDivByZeroException() {
        return "На ноль делить нельзя!";
    }
}
