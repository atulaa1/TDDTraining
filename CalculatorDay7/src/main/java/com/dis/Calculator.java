package com.dis;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/4/13
 * Time: 1:54 PM
 */
public class Calculator {

    public static int Add(String input) throws Exception {
        if(input.length()== 0)
            return 0;
        else
        {
            String delimiter = ",\n";
            String expression = input;
            boolean checkNegative = input.matches("-+\\d+");
//            if(checkNegative)
//               throw new NumberFormatException("negatives not allowed");
            if(input.contains("//"))
            {
                delimiter = input.substring(2,3);
                expression = input.substring(4);
            }

            System.out.println("  " + delimiter + checkNegative);
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
