package Concurrency;

/**
 * Created by sanyamgupta on 15/09/18.
 */
public class DeadlockHElper {

    Object key1 = new Object();
    Object key2 = new Object();

    public void method1(){
        synchronized (key1){
            System.out.println("Method 1");
            method2();
        }
    }

    public void method2(){
        synchronized (key2){
            System.out.println("Method 2");
            method3();
        }
    }

    public void method3(){
        synchronized (key1){
            System.out.println("Method 3");

        }
    }

}
