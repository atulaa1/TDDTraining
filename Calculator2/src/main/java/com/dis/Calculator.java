package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/28/13
 * Time: 1:52 PM
 */
public class Calculator {



    public int Add(String input)
    {
        if(input.length() ==0)
            return 0;
        else
        {
            String numbers[] = input.split(",|\n");
            if(numbers.length > 1)
            {
                int temp = 0;
                for(String n : numbers)
                {
                    temp += Integer.parseInt(n);
                }
                return temp;
            }
            else
                return Integer.parseInt(input);
        }


    }

    public int Add1(String input)
    {
        if(input.length() ==0)
            return 0;
        else
        {
            String numbers[] = input.split(",");
            if(numbers.length > 1)
            {
                int temp = 0;
                for(String n : numbers)
                {
                    temp += Integer.parseInt(n);
                }
                return temp;
            }
            else
                return Integer.parseInt(input);
        }


    }
}
