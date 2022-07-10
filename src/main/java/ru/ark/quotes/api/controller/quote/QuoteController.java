package ru.ark.quotes.api.controller.quote;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import ru.ark.quotes.api.dto.Quote;
import ru.ark.quotes.api.service.QuoteService;

import java.util.List;

@RestController
public class QuoteController {

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    private final QuoteService quoteService;

    @Operation(
            method = "POST",
            tags = "Quotes",
            description = "Create a new quote",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = String.class)
                    )))
    @PostMapping("/create")
    public boolean create(@RequestBody String body) {
        return quoteService.create(body);
    }

    @Operation(method = "GET",
            tags = "Quotes",
            description = "Create the quote",
            parameters = @Parameter(
                    name = "id",
                    description = "Quote identifier",
                    required = true))
    @GetMapping("/get/{id}")
    public Quote get(@PathVariable(name = "id") Long id) {
        return quoteService.get(id);
    }

    @Operation(
            method = "POST",
            tags = "Quotes",
            description = "Update the quote",
            parameters = @Parameter(
                    name = "id",
                    description = "The quote id to be updated",
                    required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    description = "The new quote text",
                    content = @Content(
                            schema = @Schema(implementation = String.class)
                    )))
    @PostMapping("/update/{id}")
    public boolean update(@PathVariable(name = "id") Long id, @RequestBody String body) {
        return quoteService.update(id, body);
    }

    @Operation(
            method = "DELETE",
            tags = "Quotes",
            description = "Delete the quote",
            parameters = @Parameter(
                    name = "id",
                    description = "The quote id to be deleted",
                    required = true))
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable(name = "id") Long id) {
        return quoteService.delete(id);
    }

    @Operation(method = "GET",
            tags = "Quotes",
            description = "Get top 10 quotes")
    @GetMapping("/quotes")
    public List<Quote> getQuotes() {
        return quoteService.getTop10();
    }

}
