
package com.fabzdev.generics;

public class MutableObjectTest1 {
        private static boolean someMethod(MutableObject1 myRefArg) {
        myRefArg.set("Uno");
        return true;
        }
    
    public static void main(String[] args) {
        String myResult = null;
        
        MutableObject1<String> byRefArg = new MutableObject1<>();
        if(someMethod(byRefArg)){
            myResult = byRefArg.get();
        }
        System.out.println(myResult);
    }


}
