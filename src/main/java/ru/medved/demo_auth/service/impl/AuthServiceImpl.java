package ru.medved.demo_auth.service.impl;

import jakarta.persistence.EntityExistsException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.medved.demo_auth.enums.RoleUser;
import ru.medved.demo_auth.security.controller.request.RegisterRequest;
import ru.medved.demo_auth.security.controller.request.SignInRequest;
import ru.medved.demo_auth.security.controller.response.AuthResponse;
import ru.medved.demo_auth.security.entity.Role;
import ru.medved.demo_auth.security.entity.User;
import ru.medved.demo_auth.security.jwt.JwtUtils;
import ru.medved.demo_auth.security.repository.RoleRepository;
import ru.medved.demo_auth.security.repository.UserRepository;
import ru.medved.demo_auth.service.AuthService;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByLogin(request.getLogin())) {
            log.error("Error: User with login is already exist!");// TODO: 09.02.2023 передеать на исключения и формировать badResponse 
            return new AuthResponse();
        }

        Set<Role> roles = Set.of(roleRepository.findByName(RoleUser.USER).orElseThrow(() -> new EntityExistsException("Default role not found")));

        User user = User.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .name(request.getName())
                .password(encoder.encode(request.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtUtils.generateJwtToken(user.getLogin()))
                .build();
    }

    @Override
    public AuthResponse signIn(SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return AuthResponse.builder()
                .token(jwtUtils.generateJwtToken(authentication))
                .build();
    }
}
