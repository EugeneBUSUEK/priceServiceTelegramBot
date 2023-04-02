package com.example.priceServiceTelegramBot.service;

import com.example.priceServiceTelegramBot.config.BotConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@RequiredArgsConstructor
@Component
public class TelegramBot extends TelegramLongPollingBot{

    final BotConfig config;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();

            switch (messageText) {
                case "/start":
                    startCommandRecieved(update.getMessage().getChatId(), update.getMessage().getChat().getFirstName());
                    break;
                default:
                    sendMessage(update.getMessage().getChatId(), "Unsupported command");
            }
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    private void startCommandRecieved(Long chatId, String name) {
        String answer = "Hi, " + name + ", nice to meet you.";
        sendMessage(chatId, answer);
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage(String.valueOf(chatId), text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
