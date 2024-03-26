package task2.smartercalculator.calculatorResult;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;

public class IntegerCalculationResult extends AbstractCalculationResult {
    public IntegerCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = getRequest();
        Integer leftOperand = (Integer) request.getLeftOperand();
        Integer rightOperand = (Integer) request.getRightOperand();

        try {
            return switch (request.getOperation()) {
                case "+" -> leftOperand + rightOperand;
                case "-" -> leftOperand - rightOperand;
                case "*" -> leftOperand * rightOperand;
                case "/" -> leftOperand / rightOperand;
                default -> throw new InvalidOperationException("invalid operation "
                        + leftOperand +request.getOperation() + rightOperand);
            };
        } catch (ArithmeticException e) {
            throw new InvalidOperationException("invalid operation " + leftOperand + "/" + rightOperand);
        }
    }
}
