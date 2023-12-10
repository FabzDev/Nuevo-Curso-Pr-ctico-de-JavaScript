package com.fabzdev.multithread;

/**
 *
 * @author fabio
 */
public class MultithreadTest3 extends Thread {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Prueba " + i);
                }
            }
        });
        
        t.start();
        System.out.println("FIN");
    }
}
