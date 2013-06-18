package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/14/13
 * Time: 11:35 AM
 */
public class A {

    public void  callme() {
        System.out.println("TTTTTTt");
    }
    public void  test1() {
        System.out.println("A");
        try{
            Thread.sleep(8000);
        }   catch (Exception e)    {

        }
        callme();
    }
}
