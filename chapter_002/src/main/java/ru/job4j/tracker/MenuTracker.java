package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version Id
 * @since 0.1
 */
public class MenuTracker {

    private  Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }
    public void select(int key) {
        this.actions.get(key).execut(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        private int key;
        private String action;

        public AddItem(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
            System.out.println("------------ Новая заявка с Name : " + item.getName() + "-----------");
            System.out.println("------------ Новая заявка с Description : " + item.getDescription() + "-----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавление новой заявки.");
        }
    }

    private class ShowItems implements UserAction {
        private int key;
        private String action;

        public ShowItems(int key, String action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Список всех заявок --------------");
            System.out.println("Id  | Name");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. | %s", item.getId(), item.getName()));
            }
            System.out.println("----------------------------------------------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Список всех заявок.");
        }
    }

    private class UpdateItem implements UserAction {
        private int key;
        private String action;

        public UpdateItem(int key, String action) {
            this.key = key;
            this.action = action;
        }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите Id заявки для редактирования: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("---------- Заявка была отредактирована ----------");
            } else {
                System.out.println("----------------- Нет такого Id -----------------");
                System.out.println("--------- Заявка была не отредактирована --------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактирование заявки.");
        }
    }

    private class DeleteItem implements UserAction {
        private int key;
        private String action;

        public DeleteItem(int key, String  action) {
            this.key = key;
            this.action = action;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("--------- Удаление заявки по Id ----------");
            String id = input.ask("Введите Id для удаления: ");
            if (tracker.delete(id)) {
                System.out.println("-------------- Заявка удалена ------------");
            } else {
                System.out.println("--------------- Нет такого Id ------------");
                System.out.println("------------- Заявка не удалена ----------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки по Id.");
        }
    }

    private class FindItemById implements UserAction {
        private int key;
        private String action;

        public FindItemById(int key, String  action) {
            this.key = key;
            this.action = action;
        }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите Id для поиска: ");
            System.out.println("-------------Заявка найдена: " + tracker.findById(id) + "----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по ID.");
        }
    }

    private class FindItemsByName implements UserAction {
        private int key;
        private String action;

        public FindItemsByName(int key, String  action) {
            this.key = key;
            this.action = action;
        }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Поиск Name в заявках --------------");
            String name = input.ask("Введите Name для поиска: ");
            System.out.println("-------------Заявка(и) найдена(ы)"
                    + Arrays.toString(tracker.findByName(name)) + "----------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск Name в заявках.");
        }
    }

    private class ExitProgram implements UserAction {
        private int key;
        private String action;

        public ExitProgram(int key, String  action) {
            this.key = key;
            this.action = action;
        }
        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execut(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход с программы.");
        }
    }
}
