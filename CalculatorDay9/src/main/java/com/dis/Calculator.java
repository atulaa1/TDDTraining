package com.dis;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/7/13
 * Time: 1:59 PM
 */
public class Calculator {
    public static int Add(String input){
        if(input.length() == 0)
        {
            return 0;
        }
        else
        {

            String delimiter = "";
            String expression = "";
            boolean check = false;
            if(input.contains("//") && input.contains("["))
            {
                delimiter += input.substring(input.indexOf("[")+1,input.indexOf("]"));
                System.out.println(input.indexOf("["));
                expression = input.substring(input.indexOf("]")+2);
            }
            else if(input.contains("//"))
            {
                delimiter = input.substring(2,3);
                expression = input.substring(4);
            }
            else
            {
                delimiter = ",|\n";
                expression = input;

            }


            int temp = 0;
            System.out.println("D:" + delimiter + " E:" + expression);
            String number[] = expression.split(delimiter);
            String negativeList = "";
            for(String n : number)
            {
                if(Integer.parseInt(n) < 0)
                {
                    check = true;
                    negativeList += " " + n;
                }
                if(Integer.parseInt(n) < 1000)
                    temp += Integer.parseInt(n);
            }
            if(check)
                throw new IllegalArgumentException("negatives not allowed" +negativeList);
            return temp;
        }

    }
}
