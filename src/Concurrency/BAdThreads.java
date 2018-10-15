package Concurrency;

/**
 * Created by sanyamgupta on 06/10/18.
 */
public class BAdThreads {

    static String message;

    private static class CorrectorThread
            extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats.";
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        System.out.println(message);
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}