package pl.myprojects.loganto.models.calculator;

import java.math.BigDecimal;

public class CalculatorPerSquareMeters implements ChargesCalculator {
    @Override
    public BigDecimal calculate(CalculatorParameters parameters) {
        return null;
    }

    @Override
    public CalculatorType getCalculatorType() {
        return CalculatorType.PER_SQUARE_METERS;
    }
}
