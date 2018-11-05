package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * @author Konstantin Kazakov(email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * Метод для .
     * @param height Высота пирамиды
     * @param weight Ширина пирамиды
     * @return Рисунок пирамиды.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
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
        return this.loopBy(
                h,
                h * 2 - 1,
                (row, column) -> row >= h - column - 1 && row + h - 1 >= column
        );
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
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
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
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column -1
        );
    }
}
