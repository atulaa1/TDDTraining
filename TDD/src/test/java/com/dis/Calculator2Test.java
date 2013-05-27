package com.dis;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: dungpx
 * Date: 5/27/13
 * Time: 2:15 PM
 */
public class Calculator2Test {

    @Test
    public void testEmptyString()
    {
        Calculator2 cal = new Calculator2();
        Assert.assertEquals(0, cal.Add(""));

    }

    @Test
    public void testWithOneNumber()
    {
        Calculator2 cal = new Calculator2();
        Assert.assertEquals(1,cal.Add("1"));
    }

    @Test
    public void testWithTwoNumber()
    {
        Calculator2 cal = new Calculator2();
        Assert.assertEquals(3,cal.Add("1,2"));
    }
}
