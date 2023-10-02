/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.dataStructures;

import java.util.StringTokenizer;

/**
 *
 * @author fabio
 */
public class Postfijo {

    public Stack stack = new Stack(100);
    public Double result;

    private boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    private boolean isNumber(String str) {
        int dot = -1;
        int digits = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!isDigit(str.charAt(i))) {
                if (str.charAt(i) == '.') {
                    if (dot != -1) {
                        return false;
                    }
                    dot = 1;
                } else if (str.charAt(i) == '-') {
                    if (i != 0) {
                        return false;
                    }
                    digits++;
                } else {
                    return false;
                }
            }
        }
        if(str.length() == 1 && digits == 1){
            return false;
        }
        return true;
    }

    private void calculate(String statement) {
        StringTokenizer st = new StringTokenizer(statement, " ");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (isNumber(token)) {
                Double number = Double.parseDouble(token);
                stack.push(number);
            } else if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                Double op2 = (Double) stack.pop();
                Double op1 = (Double) stack.pop();

                switch (token) {
                    case "+":
                        result = op1 + op2;
                        stack.push(result);
                        break;
                    case "-":
                        result = op1 - op2;
                        stack.push(result);
                        break;
                    case "*":
                        result = op1 * op2;
                        stack.push(result);
                        break;
                    case "/":
                        result = op1 / op2;
                        stack.push(result);
                        break;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        Postfijo ps = new Postfijo();
        ps.calculate("5 6 + 9 + 2 / 5 * -1 * 2 * -1 *");
//        System.out.println(ps.stack.peak());
        System.out.println(ps.result);
        
        System.out.println("- isNumber? " + ps.isNumber("-"));
    }

}
