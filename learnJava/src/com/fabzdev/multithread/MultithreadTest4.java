package com.fabzdev.multithread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class MultithreadTest4 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count += 1; // esta es una sección crítica, porque solo debe ser ejecutada por un thread a la vez para que no se genere un acceso simultaneo.
            System.out.println("Conteo " + count);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        MultithreadTest4 test4 = new MultithreadTest4();
        
        Thread t1 = new Thread(test4);
        Thread t2 = new Thread(test4);
        
        t1.start();
        t2.start();
        try{Thread.sleep(200);}catch (InterruptedException e){}
        System.out.println("Programa finalizado. Conteo: " + test4.count);
        
    }
}
