package task2.smartercalculator;

import task2.smartercalculator.calculatorResult.AbstractCalculationResult;
import task2.smartercalculator.calculatorResult.CalculationResult;
import task2.smartercalculator.calculatorResult.PrintingCalculationResult;
import task2.smartercalculator.exceptions.InvalidArgumentsLengthException;
import task2.smartercalculator.exceptions.UnknownOperandTypeException;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
                "abc", "+", "9",
                "1.0", "/", "0",
                "1", "/", "0",
                "true", "+", "true",
                "2.54", "+", "abcd"
                //, "1"
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        try {
            SmarterCalculator.calculate(args)
                    .stream()
                    .map(PrintingCalculationResult::new)
                    .forEach(PrintingCalculationResult::computeResult);
        } catch (InvalidArgumentsLengthException e) {
            System.err.println("unknown operand type " + e.getMessage());
        }
    }
}
