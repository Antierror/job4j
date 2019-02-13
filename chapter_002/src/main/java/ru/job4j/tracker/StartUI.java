package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("Введите число:", range));
        } while (!"y".equals(this.input.ask("Выйти с программы?(y - Yes)")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
