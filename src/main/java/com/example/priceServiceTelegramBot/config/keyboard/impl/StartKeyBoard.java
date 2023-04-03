package com.example.priceServiceTelegramBot.config.keyboard.impl;

import com.example.priceServiceTelegramBot.config.keyboard.KeyBoard;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartKeyBoard implements KeyBoard {

    @Override
    public ReplyKeyboardMarkup getReplyKeyboardMarkup() {

        KeyboardRow row = new KeyboardRow();

        row.add("кросовки");
        row.add("одежда");
        row.add("аксессуары");

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        keyboardRows.add(row);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(keyboardRows);

        return replyKeyboardMarkup;
    }
}
