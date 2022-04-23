package az.ingress.bookstore.service;

import az.ingress.bookstore.model.JwtResponse;
import az.ingress.bookstore.model.LoginRequest;
import az.ingress.bookstore.model.MessageResponse;
import az.ingress.bookstore.model.SignupRequest;

public interface AuthService {
    JwtResponse authenticate(LoginRequest loginRequest);

    MessageResponse register(SignupRequest signUpRequest);
}