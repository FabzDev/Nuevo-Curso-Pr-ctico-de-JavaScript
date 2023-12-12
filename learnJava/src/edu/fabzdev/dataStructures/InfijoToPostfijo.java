package edu.fabzdev.dataStructures;

import java.util.StringTokenizer;

public class InfijoToPostfijo {

    public boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    public boolean isNumber(String str) {
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
        if (str.length() == 1 && digits == 1) {
            return false;
        }
        return true;
    }

    public void addPostfijo(StringBuilder postfijo, String token) {
        if (!(postfijo.length() == 0)) {
            postfijo.append(" ");
        }
        postfijo.append(token);
    }

    public boolean isOperator(String token) {
        if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
            return true;
        } else {
            return false;
        }
    }

    public int getPriority(String op) {
        if ("*".equals(op) || "/".equals(op)) {
            return 2;
        }
        if ("+".equals(op) || "-".equals(op)) {
            return 1;
        } else {
            return 0;
        }
    }

    public String convertir(String infijo) {
        StringBuilder postfijo = new StringBuilder();
        StringTokenizer st = new StringTokenizer(infijo, " ");
        Stack<String> stack = new Stack<>(100);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if ("(".equals(token)) {
                stack.push(token);
            } else if (isNumber(token)) {
                addPostfijo(postfijo, token);
            } else if (isOperator(token)) {
                if (stack.size() > 0) {
                    String peak = stack.peak();
                    while ((getPriority(peak) >= getPriority(token)) && isOperator(peak) && stack.size() > 0 && !("(".equals(peak))) {
                        addPostfijo(postfijo, peak);
                        peak = stack.pop();
                    }
                    stack.push(token);

                } else {
                    stack.push(token);
                }
            } else if (")".equals(token)) {
                while (!("(".equals(stack.peak())) && stack.size() >= 0) {
                    addPostfijo(postfijo, stack.pop());
                }
                stack.pop();
            }
        }
        while (stack.size() > 0) {
            addPostfijo(postfijo, stack.pop());
        }

        return postfijo.toString();
    }

    public static void main(String[] args) {
        InfijoToPostfijo conversor = new InfijoToPostfijo();
        String postfijo = conversor.convertir("1 / ( 2 + 3 ) + 5");
        System.out.println(postfijo);
        
        Postfijo pf = new Postfijo();
        System.out.println(pf.calculate(postfijo));
    }
}
