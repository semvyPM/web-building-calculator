package org.example.sbv.controller;

import org.example.sbv.entity.UsersUsersGroup;
import org.example.sbv.response.UserRequest;
import org.example.sbv.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UsersService usersService;
    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }


    @PostMapping("/authuser")
    @ResponseBody
    public ResponseEntity<List<UsersUsersGroup>> getUser(@RequestBody UserRequest userRequest) {
        List<UsersUsersGroup> userFind = usersService.findUsersByLogin(userRequest);
        if (userFind != null) {
            return ResponseEntity.ok(userFind);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
