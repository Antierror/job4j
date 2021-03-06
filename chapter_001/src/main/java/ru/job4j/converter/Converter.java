package ru.job4j.converter;

/**
 * Конверте валют.
 */
public class Converter {
    /**
     * Конвертируем валюту рубли в евро.
     * @param value рубли.
     * @return result в Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return result в Доллары.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллар.
     * @return result в рублях.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return result в рублях.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

}