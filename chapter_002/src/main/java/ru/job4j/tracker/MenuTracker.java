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
        this.actions.add(new AddItem(0, "Добавление новой заявки."));
        this.actions.add(new ShowItems(1, "Список всех заявок."));
        this.actions.add(new UpdateItem(2, "Редактирование заявки."));
        this.actions.add(new DeleteItem(3, "Удаление заявки по Id."));
        this.actions.add(new FindItemById(4, "Поиск заявки по ID."));
        this.actions.add(new FindItemsByName(5, "Поиск Name в заявках."));
        this.actions.add(new ExitProgram(6, "Выход с программы."));
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

    private class AddItem extends BaseAction {

        public AddItem(int key, String action) {
            super(key, action);
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
    }

    private class ShowItems extends BaseAction {
        private int key;
        private String action;

        public ShowItems(int key, String action) {
            super(key, action);
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
    }

    private class UpdateItem extends BaseAction {
        private int key;
        private String action;

        public UpdateItem(int key, String action) {
            super(key, action);
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
    }

    private class DeleteItem extends BaseAction {
        private int key;
        private String action;

        public DeleteItem(int key, String  action) {
            super(key, action);
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
    }

    private class FindItemById extends BaseAction {
        private int key;
        private String action;

        public FindItemById(int key, String  action) {
            super(key, action);
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID --------------");
            String id = input.ask("Введите Id для поиска: ");
            System.out.println("-------------Заявка найдена: " + tracker.findById(id) + "----------");
        }
    }

    private class FindItemsByName extends BaseAction {
        private int key;
        private String action;

        public FindItemsByName(int key, String  action) {
            super(key, action);
        }

        @Override
        public void execut(Input input, Tracker tracker) {
            System.out.println("------------ Поиск Name в заявках --------------");
            String name = input.ask("Введите Name для поиска: ");
            System.out.println("-------------Заявка(и) найдена(ы)"
                    + Arrays.toString(tracker.findByName(name)) + "----------");
        }
    }

    private class ExitProgram extends BaseAction {
        private int key;
        private String action;

        public ExitProgram(int key, String  action) {
            super(key, action);
        }

        @Override
        public void execut(Input input, Tracker tracker) {

        }
    }
}
