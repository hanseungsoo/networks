package io.human.networks.service.impl;

import io.human.networks.controller.request.UserInfoRequest;
import io.human.networks.entity.Role;
import io.human.networks.entity.User;
import io.human.networks.repository.RoleRepository;
import io.human.networks.repository.UserRepository;
import io.human.networks.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;


@Slf4j
@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return null;
    }

    @Override
    @Transactional
    public User setUser(UserInfoRequest userInfoRequest) {
        User user = new User();
        user.setUserId(userInfoRequest.getUserId());
        user.setPassword(userInfoRequest.getPassWord());
        user.setEnabled(true);

        Role role = roleRepository.findByRoleName("USER");
        user.setRoles(Arrays.asList(role));

        log.info(user.toString());

        userRepository.insert(user);

        return user;
    }
}
