package com.ll;

import java.util.ArrayList;
import java.util.Arrays;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");
        ArrayList<String> bitsList = new ArrayList<>(Arrays.asList(expressionBits));
        int result = calc(bitsList);

        return result;
    }

    public static int calc(ArrayList<String> bitsList) {

        while(bitsList.size()!=1) {
            boolean hasPar = false;
            boolean hasMul = false;
            //괄호부터 계산
            for (int i = bitsList.size() - 3; i >= 0; i -= 2) {
                if (bitsList.get(i).contains("(")) {
                    hasPar = true;
                    bitsList.set(i, bitsList.get(i).replace("(", ""));
                    bitsList.set(i+2, bitsList.get(i+2).replace(")", ""));
                    int num1 = Integer.parseInt(bitsList.get(i));
                    int num2 = Integer.parseInt(bitsList.get(i + 2));
                    switch(bitsList.get(i+1)){
                        case("*"): {
                            bitsList.set(i+1, String.valueOf(num1 * num2));
                            break;
                        }
                        case("+"): {
                            bitsList.set(i+1, String.valueOf(num1 + num2));
                            break;
                        }
                        case("-"): {
                            bitsList.set(i+1, String.valueOf(num1 - num2));
                            break;
                        }
                    }
                    bitsList.remove(i);
                    bitsList.remove(i+1);
                }
            }
            // 괄호 없을 시 계산 처리
            if (!hasPar) {
                //곱셈부터 계산
                for (int i = 1; i < bitsList.size(); i += 2) {
                    if (bitsList.get(i).equals("*")) {
                        hasMul = true;
                        int num1 = Integer.parseInt(bitsList.get(i - 1));
                        int num2 = Integer.parseInt(bitsList.get(i + 1));
                        bitsList.set(i, String.valueOf(num1 * num2));
                        bitsList.remove(i - 1);
                        bitsList.remove(i);
                    }
                }
                // 곱셈 없으면 덧셈, 뺼셈 계산
                if (!hasMul) {
                    int num1 = Integer.parseInt(bitsList.get(0));
                    int num2 = Integer.parseInt(bitsList.get(2));
                    if (bitsList.get(1).equals("+")) {
                        bitsList.set(1, String.valueOf(num1 + num2));
                    } else if (bitsList.get(1).equals("-")) {
                        bitsList.set(1, String.valueOf(num1 - num2));
                    }
                    bitsList.remove(0);
                    bitsList.remove(1);
                }
            }
        }
        return Integer.parseInt(bitsList.getFirst());
    }
}
