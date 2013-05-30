package com.dis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/30/13
 * Time: 1:46 PM
 */
public class TestCalculator {

    @Test
    public void testEmptyString()
    {
        Assert.assertEquals(0, Calculator.Add(""));
    }

    @Test
    public void testOneNumber()
    {
        Assert.assertEquals(35,Calculator.Add("35"));
        Assert.assertEquals(22,Calculator.Add("22"));
    }

    @Test
    public void testTwoNumber()
    {
        Assert.assertEquals(22,Calculator.Add("20,2"));
        Assert.assertEquals(88,Calculator.Add("80,8"));
    }

    @Test
    public void testOtherDelimiterNewLine()
    {
        Assert.assertEquals(35, Calculator.Add("28,2\n5"));
    }

    @Test
    public void testConfigDelimiter()
    {
        // delimiter is +
        Assert.assertEquals(35, Calculator.Add("//-\n30-5"));
    }

    @Test
    public void testNavigateNumber()
    {
        Assert.assertEquals(-1, Calculator.Add("-5,40,-33"));
    }
    @Test
    public void testNumberGreaterAnThousand()
    {
        Assert.assertEquals(35, Calculator.Add("35,1009"));
    }

}


