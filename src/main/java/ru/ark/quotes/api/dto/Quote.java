package ru.ark.quotes.api.dto;

/**
 * Цитата
 */
public class Quote {

    public Quote(String text, String id, long likes, long dislikes) {
        this.text = text;
        this.id = id;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    /**
     * Текст цитаты
     */
    private final String text;

    /**
     * Идентификатор цитаты
     */
    private final String id;
    /**
     * Количество лайков
     */
    private final long likes;
    /**
     * Количество дизлайков
     */
    private final long dislikes;

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public long getLikes() {
        return likes;
    }

    public long getDislikes() {
        return dislikes;
    }
}
