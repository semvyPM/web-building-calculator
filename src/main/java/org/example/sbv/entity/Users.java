package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
@Entity
@Table(name = "users", schema = "public", catalog = "building_calculator") // catalog = "db"
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State stateId;
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
    @Column(name = "phone", nullable = false, length = 16)
    private String phone;
    @Basic
    @Column(name = "e-mail", nullable = false, length = 30)
    private String eMail;
    @Basic
    @Column(name = "login", nullable = false, length = 30)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", stateId=" + stateId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(State stateId, String lastName, String firstName, String secondName, String phone, String eMail, String login, String password) {
        this.stateId = stateId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
    }

    public Users(Integer id, State stateId, String lastName, String firstName, String secondName, String phone, String eMail, String login, String password) {
        this.id = id;
        this.stateId = stateId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
    }

    public Users() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (stateId != null ? !stateId.equals(users.stateId) : users.stateId != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        if (secondName != null ? !secondName.equals(users.secondName) : users.secondName != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (eMail != null ? !eMail.equals(users.eMail) : users.eMail != null) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stateId != null ? stateId.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
