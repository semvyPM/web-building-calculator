package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
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
    @Column(name = "phone", nullable = false, length = 16)
    private String phone;
    @Basic
    @Column(name = "e-mail", nullable = false, length = 30)
    private String eMail;
    @Basic
    @Column(name = "adress", nullable = false, length = 100)
    private String adress;
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users usersId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Users getUsersId() { return usersId;}
    public void setUsersId(Users usersId) { this.usersId = usersId;}

    public Customers() {
    }

    public Customers(String lastName, String firstName, String secondName, String phone, String eMail, String adress, Users usersId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.eMail = eMail;
        this.adress = adress;
        this.usersId = usersId;
    }

    public Customers(Integer id, String lastName, String firstName, String secondName, String phone, String eMail, String adress, Users usersId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.eMail = eMail;
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
        if (eMail != null ? !eMail.equals(customers.eMail) : customers.eMail != null) return false;
        if (adress != null ? !adress.equals(customers.adress) : customers.adress != null) return false;
        if (usersId != null ? !usersId.equals(customers.usersId) : customers.usersId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (usersId != null ? usersId.hashCode() : 0);
        return result;
    }
}
