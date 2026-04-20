package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" \\+ ");
        int result = 0;

        for(int i=0; i<expressionBits.length; i++){
            String[] innerBits = expressionBits[i].split(" - ");
            if(innerBits.length == 1) continue;
            int num1 = Integer.parseInt(innerBits[0]);
            int num2 = Integer.parseInt(innerBits[1]);
            expressionBits[i] =  String.valueOf(num1 - num2);
        }

        for(String bit : expressionBits){
            int bitToNum = Integer.parseInt(bit);
            result += bitToNum;
        }
        return result;
    }

}
