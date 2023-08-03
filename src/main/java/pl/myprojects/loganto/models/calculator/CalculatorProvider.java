package pl.myprojects.loganto.models.calculator;

import java.util.HashMap;
import java.util.List;


public class CalculatorProvider {

    HashMap<CalculatorType, ChargesCalculator> calculatorTypeSelector;
    List<ChargesCalculator> calculators;

    ChargesCalculator selectCalculator(CalculatorType calculatorType) {
        return calculatorTypeSelector.get(calculatorType);

    }

    public CalculatorProvider(List<ChargesCalculator> calculators) {
        this.calculators = calculators;
    }
}
