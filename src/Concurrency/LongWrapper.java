package Concurrency;

/**
 * Created by sanyamgupta on 15/09/18.
 */
public class LongWrapper {

    Object key = new Object();

    long l = 0;

    public void increment(){
        //synchronized (key){
            l++;
        //}
    }

    public long getValue(){
        return l;
    }
}
