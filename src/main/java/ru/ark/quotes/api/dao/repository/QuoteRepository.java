package ru.ark.quotes.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ark.quotes.api.dao.model.Quote;

import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    /**
     * Находит цитату по guid
     * @param guid идентификатор
     * @return optional
     */
    Optional<Quote> findByGuid(String guid);
}
