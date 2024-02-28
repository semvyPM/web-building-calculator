package org.example.sbv.controller;

import org.example.sbv.entity.UsersUsersGroup;
import org.example.sbv.response.UserRequest;
import org.example.sbv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/authuser")
    @ResponseBody
    public ResponseEntity<List<UsersUsersGroup>> getUser(@RequestBody UserRequest userRequest) {
        List<UsersUsersGroup> userFind = userService.findUsersByLogin(userRequest);
        if (userFind != null) {
            return ResponseEntity.ok(userFind);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
