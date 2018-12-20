package ru.job4j.tracker;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
//        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return null;
    }

//    public void replace(String id, Item item) {
//
//    }
//    public void delete(String id) {
//
//    }
//    public Item[] findAll() {
//
//    }
//    public Item[] findByName(String key) {
//
//    }
//    public Item[] findById(String id) {
//
//    }
}
