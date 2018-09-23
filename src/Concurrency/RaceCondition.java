package Concurrency;

/**
 * Created by sanyamgupta on 15/09/18.
 */
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        LongWrapper lw = new LongWrapper();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<1000; i++){
                    lw.increment();
                }
            }
        };

        Thread[] threadPool = new Thread[1000];
        for(int i=0; i<1000; i++){
            threadPool[i] = new Thread(run);
            threadPool[i].start();
        }

        for(int i=0; i<1000; i++){
            threadPool[i].join();
        }

        System.out.println(lw.getValue());

    }


}
