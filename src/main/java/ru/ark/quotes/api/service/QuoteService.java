package ru.ark.quotes.api.service;

import ru.ark.quotes.api.dto.Quote;

import java.util.List;

/**
 * Сервис для работы с цитатами
 */
public interface QuoteService {


    /**
     * Добавляет новую цитату
     * @param text цитата
     * @return true - была добавлена, false - не была
     */
    boolean create(String text);

    /**
     * Получает информацию о цитате
     * @param id идентификатор цитаты
     * @return цитата или null
     */
    Quote get(Long id);

    /**
     * Обновляет информацию о цитате
     * @param id идентификатор
     * @param text новый текст
     * @return true - обновил, false - нет
     */
    boolean update(Long id, String text);

    /**
     * Удаляет цитату
     * @param id идентификатор цитаты
     * @return true - была удалена, false - не была
     */
    boolean delete(Long id);

    /**
     * Получает 10
     * @return список цитат
     */
    List<Quote> getTop10();
}
