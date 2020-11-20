package io.human.networks.controller;

import io.human.networks.controller.request.UserInfoRequest;
import io.human.networks.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity setUser(UserInfoRequest userInfoRequest) {

        userService.setUser(userInfoRequest);

        return null;
    }
}
