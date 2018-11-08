package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }
    @Test
    public void whenStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Konstantin");
        boolean result = word.startWith("Kos");
        assertThat(result, is(false));
    }
}
