
package com.fabzdev.dataStructures;

/**
 *
 * @author fabio
 */
public class Stack<T> {
    private Object data[];
    private int sp;
    
    public Stack(int size){
        this.sp = -1;
        data = new Object[size];
    }
    
    public void push(T element){
        if(sp >= data.length-1)
            throw new StackOverflowError("Stack lleno");
        sp++;
        data[sp] = element;
    }
    
    public T pop(){
        if(sp < 0)
            throw new IllegalArgumentException("Stack vacio");
        T result = (T) data[sp];
        data[sp] = null; // prevenir fugas de memoria (memory leak)
        sp--;
        return result;
    }
    
    public T peak(){
        if(sp<0)
            throw new IllegalArgumentException("Stack vacio");
        return (T) data[sp];
    }
    
    public int size(){
        return sp+1;
    }
    
    public static void main(String[] args){
        Stack<String> stack = new Stack<>(10);
        stack.push("Fabio");
        stack.push("Yulieth");
        stack.push("Alejandro");
        
        System.out.println(stack.peak());
        System.out.println();
        
//        stack.pop();
//        System.out.println(stack.peak(stack.sp));
//        System.out.println();
//        
//        stack.pop();
//        System.out.println(stack.peak(stack.sp));
//        System.out.println();
        
        System.out.println("Tamaño = "+stack.size());
    }
}
