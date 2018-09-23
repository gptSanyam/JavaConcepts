package Concurrency;

/**
 * Created by sanyamgupta on 18/09/18.
 */
public class Singleton {

    private static Singleton instance = null;
    static Object key = new Object();
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){ //read
            instance  = new Singleton(); //write, may lead to race conditions if accessed from two different threads
        }
        return instance;
    }

    public static Singleton getInstance2(){//double check locking 
        if(instance != null){ //can also result in returning incompletely constructed objects as a result of a race condition
            return instance;
        }
        //no happens before relation between object creation and read
        //making the instance volatile will make the code functionally correct
        //but volatile variables result in poor performance
        synchronized (key) {
            if(instance==null){
                instance = new Singleton();
            }
            return instance;
        }
    }

}
