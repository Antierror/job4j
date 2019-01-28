package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final Tracker tracker = new Tracker();

    @Before
    public void loadOutput() {
        tracker.add(new Item("test name", "desc")); //Item
        tracker.add(new Item("test1 name", "desc1"));//Item2
        tracker.add(new Item("test2 name", "desc2"));//Item3
        tracker.add(new Item("test3 name", "desc3"));//Item4
        tracker.add(new Item("test4 name", "desc4"));//Item5
    }

    @After
    public void backOutput() {
        System.out.println("execute after method");
    }

    @Test
    public void whenShowAllItemm() {
        Input input = new StubInput(new String[]{"1","6"});
        new StartUI(input, tracker);
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(tracker.findAll()[1].getName(), is("test1 name"));
        assertThat(tracker.findAll()[2].getName(), is("test2 name"));
        assertThat(tracker.findAll()[3].getName(), is("test3 name"));
        assertThat(tracker.findAll()[4].getName(), is("test4 name"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        //   создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUserUpdateTheTrackerHasUpdatedItem() {
        //Напрямую добавляем заявку
        Input input = new StubInput(new String[]{"2", tracker.findAll()[0].getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteTheTrackerHasDeleteItem() {
        Input input = new StubInput(new String[]{"3", tracker.findAll()[1].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(tracker.findAll()[1].getName(), is("test2 name"));
        assertThat(tracker.findAll()[2].getName(), is("test3 name"));
        assertThat(tracker.findAll()[3].getName(), is("test4 name"));
    }

    @Test
    public void whenUserSearchTheItemId() {
        Input input = new StubInput(new String[]{"4", tracker.findAll()[2].getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[2].getName(), is("test2 name"));
    }

    @Test
    public void whenUserSearchTheItemsNames() {
        Input input = new StubInput(new String[]{"5", tracker.findAll()[0].getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
}