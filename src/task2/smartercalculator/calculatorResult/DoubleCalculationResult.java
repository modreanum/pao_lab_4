package task2.smartercalculator.calculatorResult;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;

public class DoubleCalculationResult extends AbstractCalculationResult {
    public DoubleCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = getRequest();
        Double leftOperand = (Double) request.getLeftOperand();
        Double rightOperand = (Double) request.getRightOperand();

        switch (request.getOperation()) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;

            case "/":
                if (rightOperand == 0) {
                    throw new InvalidOperationException("invalid operation " + leftOperand + "/" + rightOperand);
                }
                return leftOperand / rightOperand;

            default:
                throw new InvalidOperationException("invalid operation "
                        + leftOperand +request.getOperation() + rightOperand);
        }
    }
}
