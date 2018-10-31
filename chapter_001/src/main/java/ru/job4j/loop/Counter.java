package ru.job4j.loop;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Программа подсчета суммы четных чисел в диапазоне
     * @param start Начало диапазона.
     * @param finish Конец диапазона.
     * @return Сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
