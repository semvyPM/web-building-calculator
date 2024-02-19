package org.example.sbv.service;

import org.example.sbv.entity.Customers;
import org.example.sbv.entity.Users;
import org.example.sbv.repository.CustomersRepository;
import org.example.sbv.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public Users findUserByLogin(String login) {
        for (Users users: usersRepository.findAll()) {
            if (users.getLogin() == login) {
                return users;
            }
        }
        return null;
    }

}


