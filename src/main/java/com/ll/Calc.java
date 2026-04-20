package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");
        int result = 0;
        for(int i=1; i<expressionBits.length; i+=2){
            result = calc(expressionBits[i], expressionBits[i-1], expressionBits[i+1]);
            expressionBits[i+1] = String.valueOf(result);
        }

        return result;
    }

    public static int calc(String op, String a, String b){
        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);
        return switch (op) {
            case ("+") -> num1 + num2;
            case ("-") -> num1 - num2;
            case ("*") -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }
}
