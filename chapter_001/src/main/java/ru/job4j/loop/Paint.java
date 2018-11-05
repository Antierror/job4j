package ru.job4j.loop;

/**
 * @author Konstantin Kazakov(email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Метод для построения пирамиды в псевдографике.
     *
     *    ^
     *   ^^^
     *  ^^^^^
     * ^^^^^^^
     *
     * @param h Высота пирамиды
     * @return Рисунок пирамиды.
     */
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
        //Размер weight равен двум высотам, чтоб центр был одним то нужно -1.
        int weight = 2 * h - 1;
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= h - column - 1 && row + h - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Метод для построения правого треугольника в псевдографике.
     *
     * ^
     * ^^
     * ^^^
     * ^^^^
     *
     * @param height Высота треугольника
     * @return Рисунок правого треугольника.
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        //weight - ширина равно высоте.
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * Метод для построения левого треугольника в псевдографике.
     *
     *    ^
     *   ^^
     *  ^^^
     * ^^^^
     *
     * @param height Высота треугольника
     * @return Рисунок левого трегольника.
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= weight - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

}
