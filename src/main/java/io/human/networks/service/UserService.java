package io.human.networks.service;

import io.human.networks.controller.request.UserInfoRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public long setUser(UserInfoRequest userInfoRequest);
}
