package ru.ark.quotes.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Запрос на регистрацию пользователя
 */

public class SignupRequest {

    public SignupRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @NotBlank
    @Size(max = 20)
    private final String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private final String email;
    @NotBlank
    @Size(max = 120)
    private final String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
