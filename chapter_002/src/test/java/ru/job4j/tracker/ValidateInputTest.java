package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private List<Integer> range = new ArrayList<>();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInputData() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, введите данные еще раз.%n")
                )
        );
    }

    @Test
    public void whenInvalidInputKey() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"6", "1"})
        );
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, введите число из меню.%n")
                )
        );
    }
}