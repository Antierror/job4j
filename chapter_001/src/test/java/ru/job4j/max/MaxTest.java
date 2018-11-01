package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 10);
        assertThat(result, is(10));
    }
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maximus = new Max();
        int result = maximus.max(5, 25, 17);
        assertThat(result, is(25));
    }
}
