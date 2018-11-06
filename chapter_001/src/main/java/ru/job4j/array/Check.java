package ru.job4j.array;

/**
 * @author Konstantin Kazakov (Email: plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index != data.length/2; index++) {
            if (data[index] == data[data.length - 1]) {
                result = true;
            }
        }
        return result;
    }
}