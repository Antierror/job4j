package ru.job4j.tracker;

import java.util.Arrays;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input,this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf((input.ask("Введите число:"))));
        } while(!"y".equals(this.input.ask("Выйти с программы?(y - Yes)")));
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
