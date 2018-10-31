package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(6, 0);
        Point b = new Point(4, 0);
        Point c = new Point(2, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expented = -1D;
        assertThat(result, closeTo(expented, 0.1));
    }
}
