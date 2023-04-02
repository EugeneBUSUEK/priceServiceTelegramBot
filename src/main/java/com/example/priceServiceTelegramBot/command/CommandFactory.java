package com.example.priceServiceTelegramBot.command;

import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    public AnyCommand createCommand(CommandType commandType) {

        AnyCommand command;

        switch (commandType) {
            case START:
                command = new StartCommand();
                break;
            case SNEAKERS:
                command = new SneakersCommand();
                break;
            case CLOTHES:
                command = new ClothesCommand();
                break;
            case OTHERS:
                command = new OthersCommand();
                break;
            default:
                command = new UnsupportedCommand();
        }

        return command;
    }
}
