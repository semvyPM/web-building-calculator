package org.example.sbv.security.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.security.domain.model.States;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Запрос на регистрацию")
public class SignUpRequest {

    @Schema(description = "Имя пользователя", example = "Jon")
    @Size(min = 5, max = 30, message = "Имя пользователя должно содержать от 5 до 30 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Адрес электронной почты", example = "jondoe@gmail.com")
    @Size(min = 5, max = 30, message = "Адрес электронной почты должен содержать от 5 до 30 символов")
    @NotBlank(message = "Адрес электронной почты не может быть пустыми")
    @Email(message = "Email адрес должен быть в формате user@example.com")
    private String email;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 30, message = "Длина пароля должна быть не более 255 символов")
    private String password;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 30, message = "Длина пароля должна быть не более 255 символов")
    private String lastName;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 30, message = "Длина пароля должна быть не более 255 символов")
    private String firstName;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 30, message = "Длина пароля должна быть не более 255 символов")
    private String secondName;

    @Schema(description = "Пароль", example = "my_1secret1_password")
    @Size(max = 16, message = "Длина пароля должна быть не более 16 символов")
    private String phone;

    @Schema(description = "Пароль", example = "my_1secret1_password")
//    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private States stateId;

}