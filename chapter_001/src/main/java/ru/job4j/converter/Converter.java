package ru.job4j.converter;

/**
 * Конверте валют.
 */
public class Converter {
    private int result;
    /**
     * Конвертируем валюту рубли в евро.
     * @param value рубли.
     * @return result в Евро.
     */
    public int rubleToEuro(int value) {
        this.result = value / 70;
        return this.result;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return result в Доллары.
     */
    public int rubleToDollar(int value) {
        this.result = value / 60;
        return this.result;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллар.
     * @return result в рублях.
     */
    public int dollarToRuble(int value) {
        this.result = value * 60;
        return this.result;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return result в рублях.
     */
    public int euroToRuble(int value) {
        this.result = value * 70;
        return this.result;
    }

}