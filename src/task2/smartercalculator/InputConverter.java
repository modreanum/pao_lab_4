package task2.smartercalculator;

import task2.smartercalculator.exceptions.InvalidArgumentsLengthException;
import task2.smartercalculator.exceptions.InvalidOperationException;
import task2.smartercalculator.exceptions.UnknownOperandTypeException;
import task2.smartercalculator.requestMapper.BooleanCalculatorRequestMapper;
import task2.smartercalculator.requestMapper.CalculatorRequestMapper;
import task2.smartercalculator.requestMapper.DoubleCalculatorRequestMapper;
import task2.smartercalculator.requestMapper.IntegerCalculatorRequestMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputConverter {
    private static final List<CalculatorRequestMapper> MAPPERS = Arrays.asList(new BooleanCalculatorRequestMapper(), new IntegerCalculatorRequestMapper(), new DoubleCalculatorRequestMapper());

    public static List<CalculationRequest> mapRequests(String[] args)
            throws InvalidArgumentsLengthException {

        if (args.length < 3 || args.length % 3 != 0) {
            throw new InvalidArgumentsLengthException("invalid len");
        }

        List<CalculationRequest> calculatorRequests = new ArrayList<>();

        for (int i = 0; i < args.length; i += 3) {
            try {
                calculatorRequests.add(mapRequest(args[i], args[i + 1], args[i + 2]));
            } catch (UnknownOperandTypeException | InvalidOperationException e) {
                System.err.println(e.getMessage());
            }
        }

        return calculatorRequests;
    }

    private static CalculationRequest mapRequest(
            String leftOperandString,
            String operatorString,
            String rightOperandString) throws InvalidOperationException, UnknownOperandTypeException {

        int unknownOperandTypeExceptionCount = 0;
        for (CalculatorRequestMapper mapper : MAPPERS) {
            Optional<CalculationRequest> calculatorRequestOptional = Optional.empty();
            try {
                calculatorRequestOptional = mapper.tryMapRequest(leftOperandString, operatorString, rightOperandString);

                if (calculatorRequestOptional.isPresent()) {
                    return calculatorRequestOptional.get();
                }
            } catch (UnknownOperandTypeException e) {
                unknownOperandTypeExceptionCount++;

            } catch (InvalidOperationException e) {
                throw e;
            }
            if (unknownOperandTypeExceptionCount == MAPPERS.size()) {
                throw new UnknownOperandTypeException("unknown operand type "
                        + leftOperandString + operatorString + rightOperandString);
            }
        }

        return null;
    }
}


