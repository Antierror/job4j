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
        tracker.add(new Item("test name", "desc"));
        tracker.add(new Item("test1 name", "desc1"));
        tracker.add(new Item("test2 name", "desc2"));
        tracker.add(new Item("test3 name", "desc3"));
        tracker.add(new Item("test4 name", "desc4"));
    }

    @After
    public void backOutput() {
        System.out.println("execute after method");
    }

    @Test
    public void whenShowAllItemm() {
        Input input = new StubInput(new String[]{"1", "6"});
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
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        //   создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUserUpdateTheTrackerHasUpdatedItem() {
        //Напрямую добавляем заявку
        Input input = new StubInput(new String[]{"2", tracker.findAll()[0].getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    @Test
    public void whenUserDeleteTheTrackerHasDeleteItem() {
        Input input = new StubInput(new String[]{"3", tracker.findAll()[1].getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(tracker.findAll()[1].getName(), is("test2 name"));
        assertThat(tracker.findAll()[2].getName(), is("test3 name"));
        assertThat(tracker.findAll()[3].getName(), is("test4 name"));
    }

    @Test
    public void whenUserSearchTheItemId() {
        Input input = new StubInput(new String[]{"4", tracker.findAll()[2].getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[2].getName(), is("test2 name"));
    }

    @Test
    public void whenUserSearchTheItemsNames() {
        Input input = new StubInput(new String[]{"5", tracker.findAll()[0].getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
}