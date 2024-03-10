package org.example.sbv.security.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.sbv.security.domain.dto.JwtAuthenticationResponse;
import org.example.sbv.security.domain.dto.SignInRequest;
import org.example.sbv.security.domain.dto.SignUpRequest;
import org.example.sbv.security.domain.model.Role;
import org.example.sbv.security.domain.model.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    @SneakyThrows
    public JwtAuthenticationResponse signUp(SignUpRequest request) {

        var user = User.builder()
                .login(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .lastName(request.getLastName())        // Добавить фамилию
                .firstName(request.getFirstName())      // Добавить имя
                .secondName(request.getSecondName())    // Добавить отчество
                .phone(request.getPhone())              // Добавить номер телефона
                .statesId(request.getStateId())        // Добавить идентификатор состояния
                .build();

        userService.create(user);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());
        System.out.println(user);
        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
