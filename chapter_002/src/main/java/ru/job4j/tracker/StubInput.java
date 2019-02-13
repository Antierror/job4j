package ru.job4j.tracker;

import java.util.List;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {

    private final String[] answer;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;

    public StubInput(final String[] answer) {
        this.answer = answer;
    }

    @Override
    public String ask(String question) {
        return this.answer[this.position++];
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exit = false;
        for (int value : range) {
            if (value == key) {
                exit = true;
                break;
            }
        }
        if (exit) {
            return key;
        } else {
            throw new UnsupportedOperationException("Unsupported operation");
        }
    }
}

