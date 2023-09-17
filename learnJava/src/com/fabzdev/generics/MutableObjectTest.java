
package com.fabzdev.generics;

public class MutableObjectTest {
        private static boolean someMethod(MutableObject myRefArg) {
        myRefArg.set("Hola mundo");
        return true;
        }
    
    public static void main(String[] args) {
        String myResult = null;
        
        MutableObject myRefArg = new MutableObject();
        if(someMethod(myRefArg)){
            myResult = (String) myRefArg.get();
        }
        System.out.println(myResult);
    }


}
