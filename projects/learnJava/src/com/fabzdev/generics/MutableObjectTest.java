
package com.fabzdev.generics;

public class MutableObjectTest{
    public static void main(String[] args) {
        String value = null;
        
        MutableObject<String> mo = new MutableObject<>();
        if(someMethod(mo)){
            value = mo.getValue();
        }
        System.out.println(value);
    }
    
    public static boolean someMethod(MutableObject<String> mutable){
        mutable.setValue("Hola mundo");
        return true;
    }
}
