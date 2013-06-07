package com.dis.test;

import com.dis.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/7/13
 * Time: 1:56 PM
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
        Assert.assertEquals(0, Calculator.Add("0"));
    }

    @Test
    public void testTwoNumbers()
    {
        Assert.assertEquals(0, Calculator.Add("0,0"));
    }

    @Test
    public void testNewLineDelimiter()
    {
        Assert.assertEquals(0, Calculator.Add("0,0\n0"));
    }

    @Test
    public void testConfigDelimiter()
    {
        Assert.assertEquals(0, Calculator.Add("//&\n0&0"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber()
    {
        Assert.assertEquals(0, Calculator.Add("-1,-2"));
    }

    @Test
    public void testGreaterOneThousand()
    {
        Assert.assertEquals(0, Calculator.Add("0,10001"));
    }

    @Test
    public void testChangeLengthDelimiter() {
        Assert.assertEquals(0, Calculator.Add("//[,,,,]\n0,,,,0"));
    }

    @Test
    public void testMultipleDelimiter() {
        Assert.assertEquals(0, Calculator.Add("//[,,,,][&&]\n0,,,,0&&0"));
    }



}
