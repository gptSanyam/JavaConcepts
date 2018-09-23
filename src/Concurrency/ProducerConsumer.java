package Concurrency;

/**
 * Created by sanyamgupta on 16/09/18.
 */
public class ProducerConsumer {

    static String[] buffer = new String[10];
    static int count = 0;
    static Object lock = new Object();

    static class Producer{
        public void produceUnsafe() {
            while(isFull()){}
            buffer[count++] = "produce";
        }

        public void produce() throws InterruptedException {
            synchronized (lock){
                if(isFull()){
                    lock.wait();
                }
                buffer[count++] = "produce";
                lock.notifyAll();
            }
        }
    }

    static class Consumer{
        public void consumeUnsafe() {
            while(isEmpty()){}
            buffer[--count] = null;
        }

        public void consume() throws InterruptedException {
            synchronized (lock){
                if(isEmpty()){
                    lock.wait();
                }
                buffer[--count] = null;
                lock.notifyAll();
            }
        }
    }

    public static boolean isFull(){
        return count == buffer.length;
    }

    public static boolean isEmpty(){
        return count == 0;
    }

    public static void main(String[] args) throws InterruptedException {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable runProducer = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<50; i++){
                    //producer.produceUnsafe();
                    try {
                        producer.produce();
                        //System.out.println("Produced");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runConsumer = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<45; i++){
                    //consumer.consumeUnsafe();
                    try {
                        consumer.consume();
                        //System.out.println("Consumed");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread producerThread = new Thread(runProducer);
        Thread consumerThread = new Thread(runConsumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println(count);

    }

}
