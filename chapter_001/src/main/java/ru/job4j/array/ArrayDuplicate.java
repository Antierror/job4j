package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Удаление дубликатов в массиве.
     * @param array Входящий массив
     * @return Возвращение массива без дубликатов.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
