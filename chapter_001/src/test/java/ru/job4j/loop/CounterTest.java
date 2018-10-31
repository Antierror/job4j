package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //тест, проверяющий, что сумма чётных чисел от 1 до 15 при вызове метода counter.add будет равна 56.
        Counter counter = new Counter();
        int result = counter.add(1, 15);
        assertThat(result, is(56));
    }
}

