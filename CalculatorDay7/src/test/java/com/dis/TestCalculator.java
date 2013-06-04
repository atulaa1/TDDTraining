package com.dis;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 6/4/13
 * Time: 1:52 PM
 */
public class TestCalculator {

    @Test
    public void testEmptyString() throws Exception{
        Assert.assertEquals(0,Calculator.Add(""));
    }

    @Test
    public void testOneNumber() throws Exception{
        Assert.assertEquals(88,Calculator.Add("88"));
    }

    @Test
    public void testTwoNumber() throws Exception{
        Assert.assertEquals(88,Calculator.Add("80,8"));
    }

    @Test
    public void testDelimiterNewLine() throws Exception{
        Assert.assertEquals(88,Calculator.Add("80\n8"));
    }

    @Test
    public void testConfigDelimiter() throws Exception{
        Assert.assertEquals(88,Calculator.Add("//;\n80;8"));
    }

    @Test(expected = NumberFormatException.class)
    public void testNegativeNumber() throws Exception{
       Calculator.Add("-80,2");
    }
}
