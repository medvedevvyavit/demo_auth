package ru.medved.demo_auth.security.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @Email
    private String email;
}
