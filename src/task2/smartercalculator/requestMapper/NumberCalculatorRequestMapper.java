package task2.smartercalculator.requestMapper;

import task2.smartercalculator.CalculationRequest;
import task2.smartercalculator.exceptions.InvalidOperationException;
import task2.smartercalculator.exceptions.UnknownOperandTypeException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class NumberCalculatorRequestMapper implements CalculatorRequestMapper {

    protected static final List<String> VALID_OPERATIONS = Arrays.asList("+", "-", "*", "/");


    @Override
    public Optional<CalculationRequest> tryMapRequest(
            String leftOperandString, String operatorString, String rightOperandString)
            throws InvalidOperationException, UnknownOperandTypeException {

        Optional<CalculationRequest> optional = mapNumbers(
                leftOperandString, operatorString, rightOperandString);

        if (optional.isEmpty()) {
            throw new UnknownOperandTypeException("unknown operand type");
        }

        if (!isOperationValid(operatorString)) {
            throw new InvalidOperationException("invalid operation " + leftOperandString + operatorString + rightOperandString);
            //return Optional.empty();
        }

        return optional;
    }

    protected boolean isOperationValid(String operation) {
        return VALID_OPERATIONS.contains(operation);
    }

    protected abstract Optional<CalculationRequest> mapNumbers(String leftOperandString, String operatorString, String rightOperandString);
}
