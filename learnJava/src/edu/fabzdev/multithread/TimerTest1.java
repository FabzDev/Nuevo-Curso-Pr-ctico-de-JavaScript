package edu.fabzdev.multithread;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author fabio
 */
public class TimerTest1 {
    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            int n = 1;
            @Override
            public void run() {
                System.out.println("n = " + n);
                n++;
                if (n > 10) {
                    t.cancel();
                }
            }
        }, 1000, 100);
    }
}
