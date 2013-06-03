package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/3/13
 * Time: 2:01 PM
 */
public class Calculator {

    public static int Add(String expression)
    {
        if(expression.length() == 0)
            return 0;
        else
        {
            String delimiter = ",|\n";
            String numbers[];
            if(expression.contains("//"))
            {
                delimiter = expression.substring(2,3);
                numbers = expression.substring(4).split(delimiter);

            }
            else
                numbers = expression.split(delimiter);

            int temp = 0;
            for(String n : numbers)
            {
                temp += Integer.parseInt(n);
            }
            return temp;
        }

    }

    public boolean checkContainNegativeNumber(String input)
    {
        return true;
    }
}
