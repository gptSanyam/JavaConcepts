package Concurrency;

/**
 * Created by sanyamgupta on 15/09/18.
 */
public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        DeadlockHElper dh = new DeadlockHElper();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                dh.method1();
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                dh.method2();
            }
        };


        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
