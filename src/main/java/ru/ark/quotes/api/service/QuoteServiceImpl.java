package ru.ark.quotes.api.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.ark.quotes.api.dao.repository.QuoteRepository;
import ru.ark.quotes.api.dto.Quote;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public boolean create(String text) {
        ru.ark.quotes.api.dao.model.Quote quote = new ru.ark.quotes.api.dao.model.Quote();
        quote.setText(text);
        quoteRepository.save(quote);
        return true;
    }

    @Override
    public Quote get(Long id) {
        if (id == null || id < 0) {
            return null;
        }
        return quoteRepository.findById(id)
                .map(dao -> new Quote(dao.getText()))
                .orElse(null);
    }

    @Override
    public boolean update(Long id, String text) {
        if (id == null || id < 0) {
            return false;
        }

        return quoteRepository.findById(id).map(dao -> {
                    dao.setText(text);
                    quoteRepository.save(dao);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || id < 0) {
            return false;
        }
        return quoteRepository.findById(id)
                .map(quote -> {
                    quoteRepository.delete(quote);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<Quote> getTop10() {
        PageRequest pageable = PageRequest.of(0, 10,
                Sort.by(new Sort.Order(Sort.Direction.DESC, "id")));
        return quoteRepository.findAll(pageable).stream()
                .map(dao -> new Quote(dao.getText()))
                .collect(Collectors.toList());
    }
}
