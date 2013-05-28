package com.dis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/28/13
 * Time: 1:49 PM
 */
public class CalculatorTest {


    @Test
    public void testStringEmpty()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.Add(""));
    }

    @Test
    public void testOneNumber()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88, calculator.Add("88"));
    }

    @Test
    public void testTwoNumber()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(35,calculator.Add("30,5"));
    }

    @Test
    public void testThreeNumber()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(35,calculator.Add("2,28,5"));
    }

    @Test
    public void testNewLine()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88, calculator.Add("2\n78,8"));
    }
}
