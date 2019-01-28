package ru.job4j.tracker;

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
}
