package ru.ark.quotes.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ark.quotes.api.dao.model.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
