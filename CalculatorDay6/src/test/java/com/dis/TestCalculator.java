package com.dis;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/3/13
 * Time: 2:00 PM
 */
public class TestCalculator {

    @Test
    public void testEmptyString()
    {
        Assert.assertEquals(0,Calculator.Add(""));
    }

    @Test
    public void testOneNumber()
    {
        Assert.assertEquals(22, Calculator.Add("22"));
        Assert.assertEquals(2, Calculator.Add("2"));
    }

    @Test
    public void testTwoNumber()
    {
        Assert.assertEquals(22, Calculator.Add("20,2"));
        Assert.assertEquals(88, Calculator.Add("86,2"));
    }

    @Test
    public void testDelimiterNewLine()
    {
        Assert.assertEquals(22, Calculator.Add("18\n2,2"));
    }

    @Test
    public void testConfigDelimiter()
    {
        Assert.assertEquals(88, Calculator.Add("//;\n80;8"));
        Assert.assertEquals(88, Calculator.Add("//;\n78;8;2"));
    }
    @Test
    public void testNegativeNumber()
    {
        Assert.assertEquals(-1,Calculator.Add("1,-2"));
        Assert.assertEquals(-1,Calculator.Add("//;\n1;-2"));
    }
}
