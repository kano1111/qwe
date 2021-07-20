package com.devxschool;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

public class DoubleItAndGetMiddleTest {

    DoubleItAndGetMiddle doubleItAndGetMiddle = new DoubleItAndGetMiddle();

    @Test
    public void getDoubleTest1() {
        List<Integer> actual = doubleItAndGetMiddle.getDouble(asList(1,5,3,7));
        List<Integer> expected = asList(1, 1, 5, 5, 3, 3, 7, 7);
        assertEquals("Expected double of each element", expected, actual);
    }

    @Test
    public void getDoubleTest2() {
        List<Integer> actual = doubleItAndGetMiddle.getDouble(asList(1, 7));
        List<Integer> expected = asList(1, 1, 7, 7);
        assertEquals("Expected double of each element", expected, actual);
    }

    @Test
    public void getDoubleTest3() {
        List<Integer> actual = doubleItAndGetMiddle.getDouble(asList(0));
        List<Integer> expected = asList(0, 0);
        assertEquals("Expected double of each element", expected, actual);
    }

    @Test
    public void getDoubleTest4() {
        List<Integer> actual = doubleItAndGetMiddle.getDouble(Collections.EMPTY_LIST);
        List<Integer> expected = Collections.EMPTY_LIST;
        assertEquals("Expected double of each element", expected, actual);
    }

    @Test
    public void getDoubleTest5() {
        List<Integer> actual = doubleItAndGetMiddle.getDouble(asList(1,2,3,4,5,6,7,8,9,0));
        List<Integer> expected = asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0, 0);
        assertEquals("Expected double of each element", expected, actual);
    }


    @Test
    public void getMiddleTest1() {
        List<Integer> actual = doubleItAndGetMiddle.getMiddle(asList(1, 1, 5, 5, 3, 3, 7, 7));
        List<Integer> expected = asList(5,3);
        assertEquals("Expected middle two elements from a list", expected, actual);
    }

    @Test
    public void getMiddleTest2() {
        List<Integer> actual = doubleItAndGetMiddle.getMiddle(asList(1, 1, 7, 7));
        List<Integer> expected = asList(1, 7);
        assertEquals("Expected middle two elements from a list", expected, actual);
    }

    @Test
    public void getMiddleTest3() {
        List<Integer> actual = doubleItAndGetMiddle.getMiddle(asList(1, 7));
        List<Integer> expected = asList(1, 7);
        assertEquals("Expected middle two elements from a list", expected, actual);
    }

    @Test
    public void getMiddleTest4() {
        List<Integer> actual = doubleItAndGetMiddle.getMiddle(asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 0, 0));
        List<Integer> expected = asList(5, 6);
        assertEquals("Expected middle two elements from a list", expected, actual);
    }

}