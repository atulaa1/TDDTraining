package com.dis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/10/13
 * Time: 2:02 PM
 */
public class TestCalculator {

    @Test
    public void testEmptyString () {
        Assert.assertEquals(0, Calculator.Add(""));
    }

    @Test
    public void testOneNumber() {
        Assert.assertEquals(13, Calculator.Add("13"));
    }

    @Test
    public void testTwoNumber() {
        Assert.assertEquals(13, Calculator.Add("10,3"));
    }

    @Test
    public void testNewLineDelimiter() {
        Assert.assertEquals(13, Calculator.Add("10,1\n2"));
    }
    @Test
    public void testConfigDelimiter() {
        Assert.assertEquals(13, Calculator.Add("9,1,3"));
        Assert.assertEquals(13, Calculator.Add("//;\n10;1;2"));
    }

}
