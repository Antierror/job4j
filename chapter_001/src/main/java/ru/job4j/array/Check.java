package ru.job4j.array;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Метод проверяет все элементы в массиве явяются они true или false.
     * @param data Входящий массив
     * @return Возвращение результат проверки.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 1; index != data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}