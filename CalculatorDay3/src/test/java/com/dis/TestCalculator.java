package com.dis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/29/13
 * Time: 1:47 PM
 */
public class TestCalculator {

    @Test
    public void testEmptyString(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.Add(""));
    }

    @Test
    public void testOneNumber() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88, calculator.Add("88"));

    }

    @Test
    public void testTwoNumbers() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88, calculator.Add("80,8"));
    }

    @Test
    public void testWithOtherDelimiterNewLine()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88, calculator.Add("2\n78,8"));
    }

    @Test
    public void testChangeDelimiter()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88,calculator.Add("//-\n80-8"));
    }

    @Test
    public void testNegativeNumber()
    {
        Calculator calculator = new Calculator();
        Assert.assertEquals(88,calculator.Add("-2+90"));
    }
}
