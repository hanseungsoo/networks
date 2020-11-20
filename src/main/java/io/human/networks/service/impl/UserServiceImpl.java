package io.human.networks.service.impl;

import io.human.networks.controller.request.UserInfoRequest;
import io.human.networks.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public long setUser(UserInfoRequest userInfoRequest) {
        return 0;
    }
}
