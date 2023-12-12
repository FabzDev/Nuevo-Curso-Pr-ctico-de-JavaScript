package edu.fabzdev.multithread;

/**
 *
 * @author fabio
 */
public class MultithreadTest2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Prueba " + i);
        }
    }
     
   
    public static void main(String[] args) {
        MultithreadTest2 mt2 = new MultithreadTest2();
        mt2.start();
        System.out.println("FIN");
    }
}
