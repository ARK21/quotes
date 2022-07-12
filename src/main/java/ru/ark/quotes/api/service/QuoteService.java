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
    Quote get(String id);

    /**
     * Обновляет информацию о цитате
     * @param id идентификатор
     * @param text новый текст
     * @return true - обновил, false - нет
     */
    boolean update(String id, String text);

    /**
     * Удаляет цитату
     * @param id идентификатор цитаты
     * @return true - была удалена, false - не была
     */
    boolean delete(String id);

    /**
     * Получает 10
     * @return список цитат
     */
    List<Quote> getTop10();

    /**
     * Лайкнуть цитату
     * @param quoteGuid идентификатор цитаты
     * @return true - цитата была лайкнута, цитата не была лайкнута.
     */
    boolean toApprove(String quoteGuid);

    /**
     * Лайкнуть цитату
     * @param quoteGuid идентификатор цитаты
     * @return true - цитата была лайкнута, цитата не была лайкнута.
     */
    boolean toDisapprove(String quoteGuid);
}
