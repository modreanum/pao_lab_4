package task2.smartercalculator.calculatorResult;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;

public class BooleanCalculationResult extends AbstractCalculationResult {
    public BooleanCalculationResult(CalculationRequest request) {
        super(request);
    }

    @Override
    public Object computeResult() throws InvalidOperationException {
        CalculationRequest request = getRequest();
        Boolean leftOperand = (Boolean) request.getLeftOperand();
        Boolean rightOperand = (Boolean) request.getRightOperand();

        return switch (request.getOperation()) {
            case "&&" -> leftOperand && rightOperand;
            case "||" -> leftOperand || rightOperand;
            default -> throw new InvalidOperationException("invalid operation "
                    + leftOperand  + request.getOperation() + rightOperand);
        };
    }
}
