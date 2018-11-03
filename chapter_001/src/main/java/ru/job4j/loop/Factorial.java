package ru.job4j.loop;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Программа, вычисляющая факториал.
     * @param n Число из которого вычесляем факториал.
     * @return Число факторила.
     */
    public int calc(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }
        return sum;
    }
}
