package az.ingress.bookstore.controller.Impl;

import az.ingress.bookstore.model.JwtResponse;
import az.ingress.bookstore.model.LoginRequest;
import az.ingress.bookstore.model.MessageResponse;
import az.ingress.bookstore.model.SignupRequest;
import az.ingress.bookstore.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public JwtResponse authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return service.authenticate(loginRequest);
    }

    @PostMapping("/signup")
    public MessageResponse register(@Valid @RequestBody SignupRequest signUpRequest) {
        return service.register(signUpRequest);
    }
}