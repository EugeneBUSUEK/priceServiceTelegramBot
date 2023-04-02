package com.example.priceServiceTelegramBot.command;

public enum CommandType {
    START("start"),
    SNEAKERS("sneakers"),
    CLOTHES("clothes"),
    OTHERS("others"),
    UNSUPPORTED("unsupported");

    private String text;

    CommandType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static CommandType getCommandType(String text) {
        for (CommandType type : CommandType.values()) {
            if (type.text.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return UNSUPPORTED;
    }
}
