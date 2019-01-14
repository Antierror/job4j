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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case "0": this.createItem();
                    break;
                case "1": this.showAll();
                    break;
                case "2": this.edit();
                    break;
                case "3": this.delete();
                    break;
                case "4": this.findID();
                    break;
                case "5": this.findName();
                    break;
                case "6": exit = true;
                    break;
                default:
                    System.out.println("Вы ввели не корректный пункт!");
            }
        }
    }
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавление новой заявки");
        System.out.println("1. Список всех заявок");
        System.out.println("2. Редактирование заявки");
        System.out.println("3. Удаление заявки по Id");
        System.out.println("4. Поиск заявки по ID");
        System.out.println("5. Поиск Name в заявках");
        System.out.println("6. Выход с программы");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showAll() {
        System.out.println("------------ Список всех заявок --------------");
        System.out.println(Arrays.toString(this.tracker.findAll()));
        System.out.println("----------------------------------------------");
    }

    private void edit() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите Id заявки для редактирования: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("---------- Заявка была отредактирована ----------");
        } else {
            System.out.println("----------------- Нет такого Id -----------------");
            System.out.println("--------- Заявка была не отредактирована --------");
        }
    }

    private void delete() {
        System.out.println("--------- Удаление заявки по Id ----------");
        String id = this.input.ask("Введите Id для удаления: ");
        if (this.tracker.delete(id)) {
            System.out.println("-------------- Заявка удалена ------------");
        } else {
            System.out.println("--------------- Нет такого Id ------------");
            System.out.println("------------- Заявка не удалена ----------");
        }
    }

    private void findID() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите Id для поиска: ");
        System.out.println("-------------Заявка найдена: " + this.tracker.findById(id) + "----------");
    }

    private void findName() {
        System.out.println("------------ Поиск Name в заявках --------------");
        String name = this.input.ask("Введите Name для поиска: ");
        System.out.println("-------------Заявка(и) найдена(ы)"
                + Arrays.toString(this.tracker.findByName(name)) + "----------");
    }
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
