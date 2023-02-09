package ru.medved.demo_auth.service;

import ru.medved.demo_auth.security.controller.request.RegisterRequest;
import ru.medved.demo_auth.security.controller.request.SignInRequest;
import ru.medved.demo_auth.security.controller.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);
    AuthResponse signIn(SignInRequest request);
}
