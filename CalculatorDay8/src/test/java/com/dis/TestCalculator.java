package com.dis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/6/13
 * Time: 1:43 PM
 */
public class TestCalculator {

    @Test
    public void testEmptyString(){
        Assert.assertEquals(0, Calculator.Add(""));
    }

    @Test
    public void testOneNumber() {
        Assert.assertEquals(0, Calculator.Add("0"));
    }

    @Test
    public void testTwoNumber() {
        Assert.assertEquals(1, Calculator.Add("0,1"));
    }

    @Test
    public void testNewLineDelimiter() {
        Assert.assertEquals(2,Calculator.Add("0,1\n1"));
    }

    @Test
    public void testConfigDelimiter() {
        Assert.assertEquals(4,Calculator.Add("//&\n1&3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Calculator.Add("-1,2");

    }

    @Test
    public void testNumberGreater1000() {
        Assert.assertEquals(1,Calculator.Add("2000,1"));
    }

    @Test
    public void testLongDelimiter() {
        Assert.assertEquals(22,Calculator.Add("//[&&&]\n20&&&2"));
    }

    @Test
    public void testMultipleDelimiter () {
        Assert.assertEquals(22, Calculator.Add("//[&][,]\n18,2&2"));
    }
}
