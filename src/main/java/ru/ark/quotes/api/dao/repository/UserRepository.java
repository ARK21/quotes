package ru.ark.quotes.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ark.quotes.api.dao.model.User;

import java.util.Optional;

/**
 * Репозиторий для работы с пользователями
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
