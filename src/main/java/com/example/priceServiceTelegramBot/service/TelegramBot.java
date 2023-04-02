package com.example.priceServiceTelegramBot.service;

import com.example.priceServiceTelegramBot.command.AnyCommand;
import com.example.priceServiceTelegramBot.command.CommandFactory;
import com.example.priceServiceTelegramBot.command.CommandType;
import com.example.priceServiceTelegramBot.config.BotConfig;
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

    final CommandFactory commandFactory;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            String commandWord = messageText.substring(1).toUpperCase();
            AnyCommand command = commandFactory.createCommand(CommandType.getCommandType(commandWord));
            String answer = command.execute(update.getMessage().getChatId(), update.getMessage().getChat().getFirstName());
            sendMessage(update.getMessage().getChatId(), answer);
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
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
