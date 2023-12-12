
package edu.fabzdev.generics;

public class MutableObjectTest0 {
        
    public static void main(String[] args) {
        String myResult = null; 
        
        MutableObject0 myRefArg = new MutableObject0(); // Creando objeto vacio
        if(someMethod(myRefArg)){ // someMethod devuelve un booleano
            myResult = (String) myRefArg.getValue(); // asigna el valor del campo del objeto a la variable creada myResult
        }
        System.out.println(myResult);
    }

    private static boolean someMethod(MutableObject0 myRefArg) {
        myRefArg.setValue("Hola mundo"); // Le asigna un valor al registro/campo del objeto que fue pasado como argumento
        return true; // el método devuelve un booleano
        }

}
