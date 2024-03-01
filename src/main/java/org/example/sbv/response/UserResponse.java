package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private ArrayList<String> states;
    private String login;
    private String lastname;
    private String firstname;
    private String secondname;
    private String email;
    private String phone;
}
