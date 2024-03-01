package org.example.sbv.service;

import jakarta.servlet.http.HttpServletRequest;
    import org.example.sbv.entity.Users;
import org.example.sbv.entity.UsersUsersGroup;
import org.example.sbv.repository.UsersRepository;
import org.example.sbv.repository.UsersUsersGroupRepository;
import org.example.sbv.request.UserRequest;
import org.example.sbv.response.UserResponse;
import org.example.sbv.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersUsersGroupRepository usersUsersGroupRepository;
    private final JwtService jwtService;

    @Autowired
    public UsersService(UsersRepository usersRepository, UsersUsersGroupRepository usersUsersGroupRepository, JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.usersUsersGroupRepository = usersUsersGroupRepository;
        this.jwtService = jwtService;
    }


    public UserResponse findUsersById(Integer id) {
        Users users = usersRepository.findUsersById(id);
        if (users != null) {
            List<UsersUsersGroup> usersUsersGroups = usersUsersGroupRepository.findUsersUsersGroupByUsersId_Id(users.getId());
            if (usersUsersGroups != null) {
                ArrayList<String> states = new ArrayList<String>();
                for (UsersUsersGroup ug:usersUsersGroups) {
                    states.add(ug.getUsersgroupId().getTitle());
                }
                return new UserResponse(users.getId(), states, users.getLogin(), users.getLastName(), users.getFirstName(), users.getSecondName(), users.getEMail(), users.getPhone());
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    public Integer getUserIdByJWT(HttpServletRequest request){
        String token = (String) request.getAttribute("jwtToken");
        return jwtService.extractUserId(token);
    }
    public UserResponse getUserById(HttpServletRequest request){
        Integer id = getUserIdByJWT(request);
        return findUsersById(id);
//        return findUsersByLogin(username);
    }

}


