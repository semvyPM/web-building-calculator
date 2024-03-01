package org.example.sbv.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.sbv.response.UserResponse;
import org.example.sbv.security.service.JwtService;
import org.example.sbv.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UsersService usersService;
    private final JwtService jwtService;
    @Autowired
    public UserController(UsersService usersService, JwtService jwtService) {
        this.usersService = usersService;
        this.jwtService = jwtService;
    }


    @GetMapping("/get")
    @ResponseBody
    public UserResponse getUserInfo(HttpServletRequest request) {
//        String jwt = authorizationHeader.substring(7);
        UserResponse userResponse = usersService.getUserById(request);
        System.out.println("userResponse: " + userResponse);
        return userResponse;
    }

    @GetMapping("/tokenex")
    @ResponseBody
    public boolean getTokenStatus(HttpServletRequest request) {
//        String jwt = authorizationHeader.substring(7);
//        if (jw.getUserById(request);
//        System.out.println("userResponse: " + userResponse);
        return true;
    }
}
