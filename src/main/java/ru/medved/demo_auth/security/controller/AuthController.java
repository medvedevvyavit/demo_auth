package ru.medved.demo_auth.security.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medved.demo_auth.security.controller.request.RegisterRequest;
import ru.medved.demo_auth.security.controller.request.SignInRequest;
import ru.medved.demo_auth.security.controller.response.AuthResponse;
import ru.medved.demo_auth.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request
    ) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(
            @Valid @RequestBody SignInRequest request
    ) {
        return new ResponseEntity<>(authService.signIn(request), HttpStatus.OK);
    }

}
