package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/6/13
 * Time: 1:45 PM
 */
public class Calculator {

    public static int Add(String input)
    {
        if(input.length()==0)
            return 0;
        else
        {
            String delimiter = ",|\n";
            String expression = input;
            if(input.contains("//"))
            {
                delimiter = input.substring(2,3);
                expression = input.substring(4);
            }
            if(input.contains("["))
            {
                delimiter = input.substring(input.indexOf("[")+1,input.indexOf("]"));
                expression = input.substring(input.indexOf("]")+2);
            }
            System.out.println(delimiter + " aa: " + expression);
            String[] numbers = expression.split(delimiter);
            int temp = 0;
            boolean check = false;
            String numbersNegative = "";
            for(String n : numbers)
            {
                if(Integer.parseInt(n) < 0)
                {
                    check = true;
                    numbersNegative += " " + n;
                }
                if(Integer.parseInt(n) < 1000)
                    temp+= Integer.parseInt(n);
            }
            if(check)
                throw new IllegalArgumentException("negatives not allowed" + numbersNegative);
            return temp;
        }

    }
}
