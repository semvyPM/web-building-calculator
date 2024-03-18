package org.example.sbv.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// изменено
@Getter
@Setter
@Entity
@Table(name = "customers", schema = "public", catalog = "building_calculator") // catalog = "db"
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Basic
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Basic
    @Column(name = "second_name", nullable = false, length = 30)
    private String secondName;
    @Basic
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Basic
    @Column(name = "e-mail", nullable = false, length = 50)
    private String email;
    @Basic
    @Column(name = "adress", nullable = false, length = 100)
    private String adress;
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users usersId;

    public Users getUsersId() { return usersId;}
    public void setUsersId(Users usersId) { this.usersId = usersId;}

    public Customers() {
    }

    public Customers(String lastName, String firstName, String secondName, String phone, String email, String adress, Users usersId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.usersId = usersId;
    }

    public Customers(Integer id, String lastName, String firstName, String secondName, String phone, String email, String adress, Users usersId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.usersId = usersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (id != null ? !id.equals(customers.id) : customers.id != null) return false;
        if (lastName != null ? !lastName.equals(customers.lastName) : customers.lastName != null) return false;
        if (firstName != null ? !firstName.equals(customers.firstName) : customers.firstName != null) return false;
        if (secondName != null ? !secondName.equals(customers.secondName) : customers.secondName != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (email != null ? !email.equals(customers.email) : customers.email != null) return false;
        if (adress != null ? !adress.equals(customers.adress) : customers.adress != null) return false;
        return usersId != null ? usersId.equals(customers.usersId) : customers.usersId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (usersId != null ? usersId.hashCode() : 0);
        return result;
    }
}
