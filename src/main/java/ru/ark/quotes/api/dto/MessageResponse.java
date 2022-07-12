package ru.ark.quotes.api.dto;

/**
 * Ответ с сообщением
 */
public class MessageResponse {

    public MessageResponse(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
