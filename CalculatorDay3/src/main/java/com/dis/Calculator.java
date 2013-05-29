package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/29/13
 * Time: 1:50 PM
 */
public class Calculator {

    public int Add(String input)
    {
        if(input.length() ==0)
        {
            return 0;
        }
        else
        {

            int temp = 0;
            if(input.indexOf("//") == -1)
            {
                String numbers[] = input.split(",|\n");

                for(String n : numbers)
                {
                    temp += Integer.parseInt(n);
                }
                return temp;

            }
            else {
                // get delimiter from input
                String delimiter = input.substring(2,3);
                // get expression to calculator
                String expression = input.substring(4);
                String numbers[] = expression.split(delimiter);
                for(String n : numbers)
                {
                    temp += Integer.parseInt(n);
                }
                return temp;
            }

        }
    }
}
