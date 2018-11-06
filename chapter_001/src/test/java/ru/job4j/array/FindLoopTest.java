package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 15, 25, 44, 32, 55};
        int value = 44;
        int result = find.indexOf(input, value);
        int expect = 5;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHasLengh0ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {10, 33, 56, 12, 7, 65, 78, 14};
        int value = 50;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
