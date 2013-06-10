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
            // set delimiter default
            String delimiter = ",|\n";
            String expression = input;
            if(input.contains("//"))
            {
                delimiter = input.substring(2,3);
                expression = input.substring(4);
            }
            System.out.println(delimiter);
            System.out.println(expression);

            String numbers[] = expression.split(delimiter);
            int temp = 0;
            for(String n : numbers)
            {
                temp += Integer.parseInt(n);
            }
            return temp;
        }
    }
}
