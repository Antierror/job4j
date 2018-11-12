package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 1; index < data.length; index++) {
            if (data[0][0] != data[index][index] || data[0][data.length - 1] != data[index][data.length - 1 - index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
