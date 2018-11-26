package ru.job4j.profession;

/**
 * @author Konstantin Kazakov (plan.05.87@gmail.com).
 * @version $Id$
 * @since 0.1
 */
public class Teacher extends Profession {
    public Teacher(String name, String profession) {
        super(name, profession);
    }

    public void teach(Student student) {
    }
}
