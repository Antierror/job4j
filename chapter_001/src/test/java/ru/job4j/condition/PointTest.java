package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void point() {
        Point pointA = new Point(1, 7);
        Point pointB = new Point(5, 3);
        double result = pointA.distanceTo(pointB);
        assertThat(result, closeTo(5.65, 0.01));
    }


}
