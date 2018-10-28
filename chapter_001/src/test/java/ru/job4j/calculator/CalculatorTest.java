package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Konstantin Kazakov (plan.05.87@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test method summ.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.summ(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test method sub.
     */
    @Test
    public void whenAddTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        calc.sub(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test method div.
     */
    @Test
    public void whenAddThreeDivideByThreeThenOne() {
        Calculator calc = new Calculator();
        calc.div(3D, 3D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test method mult.
     */
    @Test
    public void whenAddTwoMultiplyByTreeThenSix() {
        Calculator calc = new Calculator();
        calc.mult(2D, 3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }
}