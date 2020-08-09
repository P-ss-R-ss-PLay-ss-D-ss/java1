
package Chuong9.Bai3;


public class MyThread2 {

    public static void main(String args[]) throws InterruptedException {
        int n = 5;
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= n; i++) {
                    System.out.printf("[%d]", i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };

        Thread threadTwo = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= n; i++) {
                    System.out.printf("(%d)", i * i);
                    System.out.println("");
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException ex) {
                        System.out.println("qq");
                    }

                }

            }
        };
        thread.start();
        threadTwo.start();
    }
}
