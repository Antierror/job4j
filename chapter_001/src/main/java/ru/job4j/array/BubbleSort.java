package ru.job4j.array;

import static java.lang.System.arraycopy;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Пузырьковый метод по сортировке массива.
     *
     * @param array Входящий массив
     * @return Возвращение отсортированный массив.
     */
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
    /**
     *  Проверка отсортированного массива.
     * @param array Входящий массив
     * @return Возврат проверки отсортированного массива.
     */
    public boolean checkSort(int[] array) {
        boolean result = true;
        for (int i = 1; i < array.length - 1; i++) {
            /*
            Если первый элемент больше следушего, то результат будет отрицательный.
             */
            if (array[i] > array[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Данны два массива отсортированных по возрастанию.
     * Необходимо получить третий массив и отсортировать его по возрастанию.
     * @param array1 Первый входящий массив
     * @param array2 Второй входящий массив
     * @return array3 Возврат третьего отсортированного массива из слитых двух.
     */
    public int[] sortMerge(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            array3[k++] = array1[i] <= array2[j] ? array1[i++] : array2[j++];
        }
        while (i < array1.length) {
            array3[k++] = array1[i++];
        }
        while (j < array2.length) {
            array3[k++] = array2[j++];
        }
        return array3;
    }
}

