package com.cherlie.game.Util;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageUtil {
    public String formatCodeBlock(String message) {
        return "```".concat(message).concat("```");
    }

    public String formatCodeLine(String message) {
        return "`".concat(message).concat("`");
    }

    public String formatQuote(String message) {
        return "> ".concat(message);
    }

    public String formatBold(String message) {
        return "**".concat(message).concat("**");
    }

    public String formatItalic(String message) {
        return "*".concat(message).concat("*");
    }

    public String formatUnderline(String message) {
        return "__".concat(message).concat("__");
    }
}
