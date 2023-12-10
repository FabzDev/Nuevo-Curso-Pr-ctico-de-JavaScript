
package com.fabzdev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class SerializableDemo {
    public static void serializable() throws FileNotFoundException, IOException{
        try(OutputStream fout = new FileOutputStream("C:/TheJavaPathV2/serializable.data")){
            ObjectOutput oo = new ObjectOutputStream(fout);
            oo.writeObject("Esto es una prueba");
            oo.writeObject(new java.util.Date());
            oo.close();
        }
    }
    
    public static void desSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
        try(InputStream fin = new FileInputStream("C:/TheJavaPathV2/serializable.data")){
            ObjectInput oi = new ObjectInputStream(fin);
            String str = (String) oi.readObject();
            java.util.Date fecha = (java.util.Date) oi.readObject();
            oi.close();
            
            System.out.println("Str = " + str);
            System.out.println("Fecha = " + fecha);
        }
    }
    
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        SerializableDemo.serializable();
           SerializableDemo.desSerializable();
    }
}
