package com.swann.service;

import com.swann.dto.RegisterRequest;
import com.swann.model.NotificationEmail;
import com.swann.model.User;
import com.swann.model.VerificationToken;
import com.swann.repository.UserRepository;
import com.swann.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private MailService mailService;

    public void signUp(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerificationToken(user);

        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String verificationToken = UUID.randomUUID().toString();
        VerificationToken token = new VerificationToken();
        token.setToken(verificationToken);
        token.setUser(user);

        verificationTokenRepository.save(token);
        return verificationToken;
    }
}
