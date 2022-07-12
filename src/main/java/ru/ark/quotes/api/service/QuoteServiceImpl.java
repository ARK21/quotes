package ru.ark.quotes.api.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.ark.quotes.api.dao.repository.QuoteRepository;
import ru.ark.quotes.api.dto.Quote;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public boolean create(String text) {
        ru.ark.quotes.api.dao.model.Quote quote = new ru.ark.quotes.api.dao.model.Quote(text, UUID.randomUUID().toString());
        quoteRepository.save(quote);
        return true;
    }

    @Override
    public Quote get(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return quoteRepository.findByGuid(id)
                .map(dao -> new Quote(dao.getText(),
                        dao.getGuid(),
                        dao.getLikes(),
                        dao.getDislikes()))
                .orElse(null);
    }

    @Override
    public boolean update(String id, String text) {
        if (StringUtils.isBlank(id)) {
            return false;
        }

        return quoteRepository.findByGuid(id).map(dao -> {
                    dao.setText(text);
                    quoteRepository.save(dao);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        return quoteRepository.findByGuid(id)
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
                .map(dao -> new Quote(dao.getText(),
                        dao.getGuid(),
                        dao.getLikes(),
                        dao.getDislikes()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean toApprove(String quoteGuid) {
        if (StringUtils.isBlank(quoteGuid)) {
            return false;
        }
        return quoteRepository.findByGuid(quoteGuid)
                .map(quote -> {
                    long likes = quote.getLikes();
                    quote.setLikes(++likes);
                    quoteRepository.save(quote);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean toDisapprove(String quoteGuid) {
        if (StringUtils.isBlank(quoteGuid)) {
            return false;
        }
        return quoteRepository.findByGuid(quoteGuid)
                .map(quote -> {
                    long dislikes = quote.getDislikes();
                    quote.setDislikes(++dislikes);
                    quoteRepository.save(quote);
                    return true;
                })
                .orElse(false);
    }
}
