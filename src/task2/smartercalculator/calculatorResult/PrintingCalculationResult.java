package task2.smartercalculator.calculatorResult;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;

public class PrintingCalculationResult implements CalculationResult {

    private final CalculationResult calculationResult;

    public PrintingCalculationResult(CalculationResult calculationResult) {
        this.calculationResult = calculationResult;
    }

    @Override
    public Object computeResult() {
        Object result;

        try {
            result = calculationResult.computeResult();
        } catch (InvalidOperationException e) {
            System.err.println(e.getMessage());
            return null;
        }

        CalculationRequest request = calculationResult.getRequest();
        System.out.println("Operation " + request + " has result " + result);
        return result;
    }

    @Override
    public CalculationRequest getRequest() {
        return calculationResult.getRequest();
    }
}
