package com.example.priceServiceTelegramBot.command;

public interface AnyCommand {

    double COEFF = 11.8 * 1.05;

    double DELIVERY_COEFF = 500.0;

    String execute(Long chatId, String text);
}
