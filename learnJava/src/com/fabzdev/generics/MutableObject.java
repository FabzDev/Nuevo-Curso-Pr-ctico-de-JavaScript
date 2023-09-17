
package com.fabzdev.generics;

public class MutableObject {
    private Object value;
    
    public void set (Object value){
        this.value = value;
    }
    
    public Object get (){
        return value;
    }
}
