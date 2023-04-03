package com.example.priceServiceTelegramBot.controller;

import com.example.priceServiceTelegramBot.config.BotConfig;
import com.example.priceServiceTelegramBot.config.keyboard.impl.StartKeyBoard;
import com.example.priceServiceTelegramBot.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@RequiredArgsConstructor
@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    final MainService service;

    final StartKeyBoard startKeyBoard;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            String answer = service.getAnswer(messageText);
            sendMessage(chatId, answer);
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

    private void sendMessage(Long chatId, String text) {
        SendMessage message = new SendMessage(String.valueOf(chatId), text);
        message.setReplyMarkup(startKeyBoard.getReplyKeyboardMarkup());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
