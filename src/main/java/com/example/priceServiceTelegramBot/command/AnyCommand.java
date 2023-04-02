package com.example.priceServiceTelegramBot.command;

public interface AnyCommand {

    String execute(Long chatId, String text);
}
