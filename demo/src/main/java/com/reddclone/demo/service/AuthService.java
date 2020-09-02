package com.reddclone.demo.service;

import com.reddclone.demo.dto.RegistrerRequest;
import com.reddclone.demo.model.User;
import com.reddclone.demo.model.VerificationToken;
import com.reddclone.demo.repository.UserRepository;
import com.reddclone.demo.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.UUID;


@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    public void signup(RegistrerRequest registrerRequest){

        User user = new User();
        user.setUsername(registrerRequest.getUsername());
        user.setEmail(registrerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerificationToken(user);
    }

    private String generateVerificationToken(User user) {

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);

        return token;
    }
}
