package com.example.priceServiceTelegramBot.support;

public class NumberHelper {

    public static Double stringToDouble(String numberText) {
        return Double.valueOf(numberText);
    }

    public static String doubleToString(Double number) {
        return String.valueOf(number);
    }
}
