package com.example.priceServiceTelegramBot.command;

public class StartCommand implements AnyCommand {

    @Override
    public String execute(Long chatId, String text) {
        return "Hi, " + text + ", nice to meet you.";
    }
}
