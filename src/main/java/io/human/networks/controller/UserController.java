package io.human.networks.controller;

import io.human.networks.controller.request.UserInfoRequest;
import io.human.networks.entity.User;
import io.human.networks.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity setUser(@RequestBody UserInfoRequest userInfoRequest) {

        userInfoRequest.setPassWord(bCryptPasswordEncoder.encode(userInfoRequest.getPassWord()));
        User user = userService.setUser(userInfoRequest);

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity("sdfsdf", HttpStatus.OK);
    }

}
