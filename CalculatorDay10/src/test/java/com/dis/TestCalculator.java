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


}
