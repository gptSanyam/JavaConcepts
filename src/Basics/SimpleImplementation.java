package Basics;

import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by sanyamgupta on 25/09/18.
 */
public class SimpleImplementation implements SimpleInterface{

    @Override
    public void increment() {
        //count++; //will give an error
        System.out.println(count);
    }

    public static void main(String[] args) {
        SimpleInterface s = new SimpleImplementation();
        s.increment();
        s.func();
    }
}
