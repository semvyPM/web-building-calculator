package org.example.sbv.entity;

import jakarta.persistence.*;
// изменено
@Entity
@Table(name = "usersUsersGroup", schema = "public", catalog = "building_calculator") // catalog = "db"
public class UsersUsersGroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users usersId;
    @ManyToOne
    @JoinColumn(name = "usersgroup_id", nullable = false)
    private UsersGroup usersgroupId;

    public UsersUsersGroup() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    public UsersGroup getUsersgroupId() {
        return usersgroupId;
    }

    public void setUsersgroupId(UsersGroup usersgroupId) {
        this.usersgroupId = usersgroupId;
    }

    public UsersUsersGroup(Users usersId, UsersGroup usersgroupId) {
        this.usersId = usersId;
        this.usersgroupId = usersgroupId;
    }

    public UsersUsersGroup(Integer id, Users usersId, UsersGroup usersgroupId) {
        this.id = id;
        this.usersId = usersId;
        this.usersgroupId = usersgroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersUsersGroup that = (UsersUsersGroup) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (usersId != null ? !usersId.equals(that.usersId) : that.usersId != null) return false;
        if (usersgroupId != null ? !usersgroupId.equals(that.usersgroupId) : that.usersgroupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (usersId != null ? usersId.hashCode() : 0);
        result = 31 * result + (usersgroupId != null ? usersgroupId.hashCode() : 0);
        return result;
    }
}
