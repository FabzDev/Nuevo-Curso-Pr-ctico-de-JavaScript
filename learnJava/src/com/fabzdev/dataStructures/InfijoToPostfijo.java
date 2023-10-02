package com.fabzdev.dataStructures;

import java.util.StringTokenizer;

public class InfijoToPostfijo {

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

    public String convertir(String infijo) {
        StringBuilder postfijo = new StringBuilder();
        StringTokenizer st = new StringTokenizer(infijo, " ");
        Stack<String> stack = new Stack<>(100);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if ("(".equals(token)) {
                stack.push(token);
            } else if () {

            }
        }

        return postfijo.toString();
    }

    public static void main(String[] args) {
        InfijoToPostfijo conversor = new InfijoToPostfijo();
        String postfijo = conversor.convertir("1 + 2");
        System.out.println(postfijo);
    }
}
