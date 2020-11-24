package io.human.networks.service;

import io.human.networks.controller.request.UserInfoRequest;
import io.human.networks.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User setUser(UserInfoRequest userInfoRequest);
}
