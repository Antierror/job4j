package ru.job4j.array;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Метод заполняющий массив числами возведенными в квадрат.
     *
     * @param bound Размер массива.
     * @return rst Возвращения всего массива
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int sum = 1;
        for (int index = 0; index != rst.length; index++) {
            rst[index] = sum * sum++;
        }
        return rst;
    }
}