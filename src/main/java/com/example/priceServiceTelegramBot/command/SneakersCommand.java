package com.example.priceServiceTelegramBot.command;

import com.example.priceServiceTelegramBot.support.NumberHelper;

public class SneakersCommand implements AnyCommand{

    private final double ADD_COEFF = 650.0 + 1940;

    @Override
    public String execute(Long chatId, String text) {
        Double price = NumberHelper.stringToDouble(text);
        int intPrice = (int) (price * COEFF + ADD_COEFF);
        if (intPrice % 100 <= 40) {
            intPrice = (((intPrice / 100) - 1) * 100) + 90;
        } else {
            intPrice = ((intPrice / 100) * 100) + 40;
        }
        return String.valueOf(intPrice);
    }
}
