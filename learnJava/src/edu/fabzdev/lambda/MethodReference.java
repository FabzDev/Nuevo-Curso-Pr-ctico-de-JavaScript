/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.fabzdev.lambda;

/**
 *
 * @author fabio
 */
public class MethodReference {

    public interface Operation {

        public int execute(int a, int b);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }
    
    public static void main(String[] args) {
        MethodReference methodRef = new MethodReference();
        
        Operation[] opArray = {
            methodRef::add,
            methodRef::sub,
            methodRef::mul,
            MethodReference::div,
            (a,b) -> a % b
        };
        
        for (Operation op : opArray){
            System.out.println(op.execute(4, 2));
        }
    }
}
