
package com.fabzdev.generics;

public class MutableObject1 <T> {
    private T value;
    
    public void set (T value){
        this.value = value;
    }
    
    public T get (){
        return value;
    }
}
