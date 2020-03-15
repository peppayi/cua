package com.xmucoder.cua.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class BMTest {

    @Test
    public void testSearch() {
        test("hello", "h", 0);
        test("hello", "l", 2);
        test("hello", "o", 4);
        test("hello", "w", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchWithEmptyPattern() {
        test("xxxx", "", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchWithEmptyText() {
        test("", "xxxx", 0);
    }

    private void test(String text, String pattern, int index) {
        int rv = new BM(pattern).search(text);
        Assert.assertEquals("index of " + pattern + " from " + text + ": ", index, rv);
    }
}