package ru.job4j.array;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    public int[] sort(int[] array) {
        for (int out = array.length - 1; out >= 1; out--) {
            for (int i = 0; i < out; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        return array;
    }
}
