package org.example.sbv.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sbv.entity.Users;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomersRequest {
    private String lastName;
    private String firstName;
    private String secondName;
    private String phone;
    private String email;
    private String adress;
    private Users usersId;

    @Override
    public String toString() {
        return "CustomersRequest{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", usersId=" + usersId +
                '}';
    }
}
