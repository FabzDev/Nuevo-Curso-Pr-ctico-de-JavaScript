package com.fabzdev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class StreamPractice {

    public void escribir() {
        try (OutputStream out = new FileOutputStream("practice.txt");) {
//            byte[] fabio = {0x46, 0x61, 0x62, 0x69, 0x6F};
            byte[] fabio = {0b01000110, 97, 98, 0x69, 111};


            for (int i = 0; i < fabio.length; i++) {
                out.write(fabio[i]);
//                out.write(174);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leer() {
        try (InputStream in = new FileInputStream("practice.txt");) {
//            int bits;
              byte[] bytesArr = new byte[2];
//            do {
//                bits = in.read();
//                if (bits != -1) {
                    System.out.println(in.read(bytesArr));
                    System.out.println(in.read(bytesArr));
                    System.out.println(in.read(bytesArr));
                    System.out.println(in.read(bytesArr));
//                    System.out.println(String.valueOf(bytesArr[5]));
//                }
//            } while (bits != -1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escribirObjeto() {
        try (OutputStream outputStream = new FileOutputStream("test2.txt"); ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);) {
            objectOutput.writeChars("Fabio");
            objectOutput.writeInt(1098);
            objectOutput.writeBoolean(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void leerObjeto() {
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("test2.txt"))) {
            char[] cadena = new char[5];
            for (int i = 0; i < cadena.length; i++) {
                cadena[i] = objectInput.readChar();
            }
            int entero = objectInput.readInt();
            boolean bool = objectInput.readBoolean();
            
            for(char c : cadena)
                System.out.print(c);
            System.out.println();
            System.out.println(entero);
            System.out.println(bool);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StreamPractice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        StreamPractice sp = new StreamPractice();
//        sp.escribir();
        sp.leer();
//        sp.escribirObjeto();
//        sp.leerObjeto();

    }
}
