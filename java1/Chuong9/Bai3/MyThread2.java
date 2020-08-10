package Chuong9.Bai3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread2 {

    public static void main(String args[]) throws InterruptedException {
        int n = 5;
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= n; i++) {
                    System.out.printf("[%d]", i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };

        Thread threadTwo = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= n; i++) {
                    System.out.printf("->(%d)", i * i);
                    System.out.println("");
                    try {
                        thread.join(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread.setPriority(10);
        threadTwo.setPriority(1);
        thread.start();
        threadTwo.start();
    }
}
