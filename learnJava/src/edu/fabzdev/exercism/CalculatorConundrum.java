package edu.fabzdev.exercism;

public class CalculatorConundrum {
    public class IllegalOperationException extends RuntimeException {
        public IllegalOperationException(String errorMessage) {
            super(errorMessage);
        }
        public IllegalOperationException(String errorMessage, Throwable cause) {
            super(errorMessage, cause);
        }
    }
    public String calculate(int operand1, int operand2, String operation) throws IllegalArgumentException, IllegalOperationException {
        if ("+".equals(operation)) {
            return String.format("%d + %d = %d", operand1, operand2, (operand1 + operand2));
        } else if ("*".equals(operation)) {
            return String.format("%d * %d = %d", operand1, operand2, (operand1 * operand2));
        } else if ("/".equals(operation)) {
            if (operand2 != 0) {
                return String.format("%d / %d = %d", operand1, operand2, (operand1 / operand2));
            } else {
                throw new IllegalOperationException("Division by zero is not allowed", new ArithmeticException());
            }
        } else if ("".equals(operation)) {
            throw new IllegalArgumentException("Operation cannot be empty");
        } else if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        } else {
            throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }
    }
}