package com.nuvalence;

import org.junit.jupiter.api.Test;

import com.nuvalence.util.config;
import com.nuvalence.util.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    static util ut = new util();

    @Test
    void test0() {
        List<String> al = new ArrayList<>(Arrays.asList("no intersection", "containement", "not adjacent"));

        config.set(0, 0, 0, 0, 0, 0, 0, 0, 1);
        config.set(5, 5, 5, 5, 5, 5, 5, 5, 2);

        List<String> res = com.nuvalence.App.getFeatures(ut.getRectangle(1), ut.getRectangle(2));
        assertEquals(al, res);
    }

    @Test
    void test1() {
        List<String> al = new ArrayList<>(Arrays.asList("intersection", "no containement", "Adjacent(Parital)"));

        config.set(10, 0, 0, 0, 10, 10, 0, 10, 1);
        config.set(5, 0, -5, 0, 5, 5, -5, 5, 2);

        List<String> res = com.nuvalence.App.getFeatures(ut.getRectangle(1), ut.getRectangle(2));
        assertEquals(al, res);
    }

    @Test
    void test2() {
        List<String> al = new ArrayList<>(Arrays.asList("intersection", "no containement", "Adjacent(Parital)"));

        config.set(10, 0, 0, 0, 10, 10, 0, 10, 1);
        config.set(5, 0, -5, 0, 5, 5, -5, 5, 2);

        List<String> res = com.nuvalence.App.getFeatures(ut.getRectangle(1), ut.getRectangle(2));
        assertEquals(al, res);
    }

    @Test
    void test3() {
        List<String> al = new ArrayList<>(Arrays.asList("intersection", "no containement", "Adjacent(Parital)"));

        config.set(10, 0, 0, 0, 10, 10, 0, 10, 1);
        config.set(5, 0, -5, 0, 5, 5, -5, 5, 2);

        List<String> res = com.nuvalence.App.getFeatures(ut.getRectangle(1), ut.getRectangle(2));
        assertEquals(al, res);
    }

    @Test
    void test4() {
        List<String> al = new ArrayList<>(Arrays.asList("no intersection", "no containement", "not adjacent"));

        config.set(10, 0, 0, 0, 10, 10, 0, 10, 1);
        config.set(-5, -10, -15, -10, -15, -5, -5, -5, 2);

        List<String> res = com.nuvalence.App.getFeatures(ut.getRectangle(1), ut.getRectangle(2));
        assertEquals(al, res);
    }
}
