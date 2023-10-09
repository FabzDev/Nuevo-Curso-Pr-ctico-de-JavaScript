package com.fabzdev.multithread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class MultithreadTest6 implements Runnable {

    private int count = 0;

    public synchronized void count() {
        count += 1;
        System.out.println("Conteo " + count);

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        MultithreadTest6 test4 = new MultithreadTest6();

        Thread t1 = new Thread(test4);
        Thread t2 = new Thread(test4);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MultithreadTest6.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Programa finalizado. Conteo: " + test4.count);

    }
}
