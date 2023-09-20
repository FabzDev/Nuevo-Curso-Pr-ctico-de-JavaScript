
package com.fabzdev.generics;

public class MutableObject<T>{
    private T value;
    
    public void setValue(T value){
        this.value = value;
    }
    
    public T getValue(){
        return value;
    }
}