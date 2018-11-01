package ru.job4j.max;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Программа определющий максимус из дыух яичел.
     * @param first Первое число.
     * @param second Второе число.
     * @return Максимальное число.
     */
    public int max(int first, int second) {
    return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        return this.max(first, this.max(second, third));
    }
}
