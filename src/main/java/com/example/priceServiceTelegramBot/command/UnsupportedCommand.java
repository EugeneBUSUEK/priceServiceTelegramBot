package com.example.priceServiceTelegramBot.command;

public class UnsupportedCommand implements AnyCommand {

    @Override
    public String execute(Long chatId, String text) {
        return "Unsupported command";
    }
}
