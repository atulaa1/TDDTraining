package com.dis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/30/13
 * Time: 1:47 PM
 */
public class Calculator {

    public static int Add(String input)
    {
        if(input.length() == 0)
            return 0;
        else
        {


            String check = input.substring(0,2);
            boolean negative = false;
            String expression = "";
            String delimiter = "";
            if(check.equals("//"))
            {
                delimiter = input.substring(2,3);

                expression = input.substring(4);

            }
            else
            {   delimiter = ",|\n";
                expression = input;
            }

            String[] number = expression.split(delimiter);
            List<String> negativeNumbers = new ArrayList<String>();
            int temp = 0;
            for(String n : number)
            {
                if(Integer.parseInt(n) < 0)
                {
                    negative = true;
                    negativeNumbers.add(n);

                }
                temp += Integer.parseInt(n);
            }
            if(negative)
            {
                System.out.println("Negatives not allowed " + negativeNumbers.toString());

                return -1;
            }
            return temp;
        }
    }
}
