package pl.myprojects.loganto.models.calculator;

import pl.myprojects.loganto.models.calculator.CalculatorParameters;
import pl.myprojects.loganto.models.calculator.CalculatorType;

import java.math.BigDecimal;

public interface ChargesCalculator {
    BigDecimal calculate(CalculatorParameters parameters);
    CalculatorType getCalculatorType();

}



