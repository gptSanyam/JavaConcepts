package Basics;

/**
 * Created by sanyamgupta on 25/09/18.
 */
public interface SimpleInterface {
    public int count = 0;
    public void increment();

    default void func(){
        System.out.println("I am the interface, and with default methods I am finally free \\u1F60E");
    }

}
