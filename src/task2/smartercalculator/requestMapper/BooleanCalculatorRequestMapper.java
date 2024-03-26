package task2.smartercalculator.requestMapper;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;
import task2.smartercalculator.exceptions.UnknownOperandTypeException;

import java.util.Optional;

public class BooleanCalculatorRequestMapper implements CalculatorRequestMapper {
    @Override
    public Optional<CalculationRequest> tryMapRequest(
            String leftOperandString, String operatorString, String rightOperandString)
            throws InvalidOperationException, UnknownOperandTypeException {

        if (!isStringABoolean(leftOperandString)
                || !isStringABoolean(rightOperandString)) {
            throw new UnknownOperandTypeException("unknown operand type");
        }

        if (!isOperationValid(operatorString)) {
            throw new InvalidOperationException("invalid operation " +
                    leftOperandString + operatorString + rightOperandString);
            //return Optional.empty();
        }

        return Optional.of(
                new CalculationRequest(leftOperandString, rightOperandString, operatorString)
        );
    }

    private static boolean isStringABoolean(String stringToVerify) {
        return "true".equals(stringToVerify) || "false".equals(stringToVerify);
    }

    private static boolean isOperationValid(String operationString) {
        return "&&".equals(operationString) || "||".equals(operationString);
    }
}
