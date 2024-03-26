package task2.smartercalculator;

import task2.smartercalculator.calculatorResult.BooleanCalculationResult;
import task2.smartercalculator.calculatorResult.AbstractCalculationResult;
import task2.smartercalculator.calculatorResult.CalculationResult;
import task2.smartercalculator.calculatorResult.DoubleCalculationResult;
import task2.smartercalculator.calculatorResult.IntegerCalculationResult;
import task2.smartercalculator.exceptions.InvalidArgumentsLengthException;
import task2.smartercalculator.exceptions.UnknownOperandTypeException;

import java.util.List;
import java.util.stream.Collectors;

public class SmarterCalculator {

    public static List<CalculationResult> calculate(String[] args) throws InvalidArgumentsLengthException {

        try {
            return InputConverter.mapRequests(args)
                    .stream()
                    .map(request -> createCalculatorResponse(request))
                    .collect(Collectors.toList());

        } catch (InvalidArgumentsLengthException e) {
            throw e;
        }


    }

    private static CalculationResult createCalculatorResponse(CalculationRequest request) {

        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> null;
        };
    }

}