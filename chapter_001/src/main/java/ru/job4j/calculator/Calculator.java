package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Konstantin Kazakov (plan.05.87@gmail.com)
 */
public class Calculator {
    private double result;

    /**
     * Method sum - суммирование.
     * @param first double numbers.
     * @param second double numbers.
     */
    public void summ(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method sub - вычитание.
     * @param first double numbers.
     * @param second double numbers.
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div - деление.
     * @param first double numbers.
     * @param second double numbers.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method mult - умножение.
     * @param first double numbers.
     * @param second double numbers.
     */
    public void mult(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult - возвращает результат.
     * @return this.result.
     */
    public double getResult() {
        return this.result;
    }
}