
package edu.fabzdev.others;


public class PrintArgs {
    public static void main(String[] args) {
        if(args.length > 0){
            System.out.println("Los argumentos recibidos son: ");
            for(String s : args)
                System.out.println(s);
        } else {
            System.out.println("No se recibieron argumentos");
        }
    }
}
