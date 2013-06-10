package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/10/13
 * Time: 2:03 PM
 */
public class Calculator {

    public static int Add(String input) {
        if(input.length()==0)
            return 0;
        else
        {
            String numbers[] = input.split(",");
            int temp = 0;
            for(String n : numbers)
            {
                temp += Integer.parseInt(n);
            }
            return temp;
        }
    }
}
