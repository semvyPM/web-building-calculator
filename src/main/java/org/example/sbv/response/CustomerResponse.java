package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String lastName;
    private String firstName;
    private String secondName;
    private String phone;
    private String email;
    private String adress;
    private Integer userId;
}
