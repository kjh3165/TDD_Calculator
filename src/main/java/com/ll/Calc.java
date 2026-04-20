package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" \\+ ");
        int result = 0;

        for(int i=0; i<expressionBits.length; i++){
            String[] innerBits = expressionBits[i].split(" - ");
            // 뺄셈식 아닌 경우
            if(innerBits.length == 1) continue;
            // 뺄셈식 계산
            int innerResult = Integer.parseInt(innerBits[0]);
            for(int j=1; j<innerBits.length; j++) {
                innerResult -= Integer.parseInt(innerBits[j]);
            }
            expressionBits[i] =  String.valueOf(innerResult);
        }
        //뺄셈 계산 후 덧셈식 계산
        for(String bit : expressionBits){
            int bitToNum = Integer.parseInt(bit);
            result += bitToNum;
        }
        return result;
    }
}
