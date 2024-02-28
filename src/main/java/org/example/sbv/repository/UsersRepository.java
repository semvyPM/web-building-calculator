package org.example.sbv.repository;


import org.example.sbv.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findUsersByLoginAndPassword(String login, String password);
}
