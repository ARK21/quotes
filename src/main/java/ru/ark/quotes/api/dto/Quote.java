package ru.ark.quotes.api.dto;

/**
 * Цитата
 */
public class Quote {

    public Quote(String text) {
        this.text = text;
    }

    /**
     * Текст цитаты
     */
    private final String text;

    public String getText() {
        return text;
    }
}
