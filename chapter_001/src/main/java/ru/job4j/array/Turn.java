package ru.job4j.array;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Метод переворачивает массив задом наперёд.
     * @param array Входящий массив
     * @return Возвращает перевернутый массив.
     */
    public int[] back(int[] array) {
        int back;
        for (int index = 0; index != array.length / 2; index++) {
            //back Присваиваем последний индекс.
            back = array[array.length - 1 - index];
            // array[array.length - 1 - index] Присваиваем первый индекс.
            array[array.length - 1 - index] = array[index];
            // array[index] = back Присваиваем последний индекс.
            array[index] = back;
        }
        return array;
    }
}
