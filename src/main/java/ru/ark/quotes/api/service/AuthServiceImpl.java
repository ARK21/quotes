package ru.ark.quotes.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ark.quotes.api.dao.model.User;
import ru.ark.quotes.api.dao.repository.UserRepository;
import ru.ark.quotes.api.dto.MessageResponse;
import ru.ark.quotes.api.dto.SignupRequest;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.encoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<MessageResponse> register(SignupRequest signupRequest) {
        ResponseEntity<MessageResponse> entity = null;

        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            entity = ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        } else if (userRepository.existsByEmail(signupRequest.getEmail())) {
            entity = ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
        } else {
            User user = new User(signupRequest.getUsername(),
                    signupRequest.getEmail(),
                    encoder.encode(signupRequest.getPassword()));
            userRepository.save(user);
            entity = ResponseEntity.ok().body(new MessageResponse("New user was successfully signed up!"));
        }
        return entity;
    }
}
