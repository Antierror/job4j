package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String questions) {
        System.out.println(questions);
        return scanner.nextLine();
    }

}
