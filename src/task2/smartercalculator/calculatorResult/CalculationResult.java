package task2.smartercalculator.calculatorResult;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;

public interface CalculationResult {
    Object computeResult() throws InvalidOperationException;

    CalculationRequest getRequest();
}
