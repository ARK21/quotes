package ru.ark.quotes.api.service;

import org.springframework.http.ResponseEntity;
import ru.ark.quotes.api.dto.MessageResponse;
import ru.ark.quotes.api.dto.SignupRequest;

/**
 * Сервис для авторизации и аутентификации
 */

public interface AuthService {

    /**
     *  Производит регистрацию пользователя
     * @param signupRequest запрос на регистрацию
     * @return ответ
     */
    ResponseEntity<MessageResponse> register(SignupRequest signupRequest);
}
