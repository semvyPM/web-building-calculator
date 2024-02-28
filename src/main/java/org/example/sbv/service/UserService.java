package org.example.sbv.service;

import org.example.sbv.entity.Users;
import org.example.sbv.entity.UsersUsersGroup;
import org.example.sbv.repository.UsersRepository;
import org.example.sbv.repository.UsersUsersGroupRepository;
import org.example.sbv.response.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;
    private final UsersUsersGroupRepository usersUsersGroupRepository;

    @Autowired
    public UserService(UsersRepository usersRepository, UsersUsersGroupRepository usersUsersGroupRepository) {
        this.usersRepository = usersRepository;
        this.usersUsersGroupRepository = usersUsersGroupRepository;
    }


    public List<UsersUsersGroup> findUsersByLogin(UserRequest userRequest) {
        Users users = usersRepository.findUsersByLoginAndPassword(userRequest.getUserlogin(), userRequest.getUserpassword());
        if (users != null) {
            List<UsersUsersGroup> usersUsersGroup = usersUsersGroupRepository.findUsersUsersGroupByUsersId_Id(users.getId());
            if (usersUsersGroup != null) {
                return usersUsersGroup;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

}


