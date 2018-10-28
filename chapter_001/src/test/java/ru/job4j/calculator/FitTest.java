package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {
   @Test
   public void manIdealWeight() {
       Fit fit = new Fit();
       double idealWeight = fit.manWeight(180);
       assertThat(idealWeight, closeTo(92.0, 0.1));
   }

    @Test
    public void womanIdealWeight() {
        Fit fit = new Fit();
        double idealWeight = fit.womanWeight(170);
        assertThat(idealWeight, closeTo(69.0, 0.1));
    }
}