package org.example.sbv.controller;

import org.example.sbv.entity.Users;
import org.example.sbv.repository.UsersRepository;
import org.example.sbv.response.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/authuser")
    @ResponseBody
    public ResponseEntity<Users> getUser(@RequestBody UserRequest userRequest) {
        System.out.println("try to search");
        Users userFind = usersRepository.findByLogin(userRequest.getUserlogin());
        if (userFind != null && userFind.getPassword().equals(userRequest.getUserpassword())) {
            System.out.println(userFind.toString());
            return ResponseEntity.ok(userFind);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
