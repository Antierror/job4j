package ru.job4j.tracker;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version Id
 * @since 0.1
 */
public interface UserAction {

    int key();

    void execut(Input input, Tracker tracker);

    String info();
}
