package com.example.priceServiceTelegramBot.config.keyboard;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface KeyBoard {

    ReplyKeyboardMarkup getReplyKeyboardMarkup();
}
