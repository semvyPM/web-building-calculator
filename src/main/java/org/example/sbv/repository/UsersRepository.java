package org.example.sbv.repository;


import org.example.sbv.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByLoginAndPassword(String login, String password);
    Users findByLogin(String login);
}
