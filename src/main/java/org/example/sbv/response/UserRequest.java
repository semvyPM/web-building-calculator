package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userlogin;
    private String userpassword;

    @Override
    public String toString() {
        return "UserRequest{" +
                "userlogin='" + userlogin + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
