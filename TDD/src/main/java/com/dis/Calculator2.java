package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/27/13
 * Time: 2:23 PM
 */
public class Calculator2 {

    public int Add(String input)
    {
        if(input.length() == 0)
            return 0;
        else if(input.length() == 1)
            return Integer.parseInt(input);
        else if(input.length() > 1)
        {

            String[] numbers = input.split(",");
            int temp = 0;
            for(int i =0; i< numbers.length;i++)
            {
                temp+= Integer.parseInt(numbers[i]);
            }
            return temp;
        }

        return -1;
    }
}
