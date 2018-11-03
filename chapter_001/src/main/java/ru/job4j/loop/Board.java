package ru.job4j.loop;

/**
 * @author Konstantin Kazakov(plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * Программа рисует шахматную доску из символов X и пробелов.
     * @param width Ширрина доски.
     * @param height Высота доски.
     * @return
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                /**
                 *  В if используеться услови для вычисление где ставить пробел или x.
                 *  При сложение i c j мы получаем четное или не четное число.
                 *  х - чётные числа.
                 *  пробел - нечётные числа.
                 */
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
