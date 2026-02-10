package com.evolution.sword.controller;

import com.evolution.sword.domain.user.User;
import com.evolution.sword.domain.user.UserDto;
import com.evolution.sword.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> userList(){
        return userService.findUsers();
    }

    @PostMapping("/users/join")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long createUser(@RequestBody UserDto dto){
        User user = dto.toEntity();
        userService.join(user);
        return user.getId();
    }
}
