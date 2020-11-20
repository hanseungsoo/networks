package io.human.networks.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSecurityVo extends User {
    private String userEmail;
    private String userAddr;
    private String userBirth;

    public UserSecurityVo(String username, String password, Collection<? extends GrantedAuthority> authorities,
                          String userEmail, String userAddr, String userBirth) {
        super(username, password, authorities);

        this.userEmail = userEmail;
        this.userAddr = userAddr;
        this.userBirth = userBirth;
    }

    public UserSecurityVo(String username, String password, boolean enabled, boolean accountNonExpired,
                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<?
        extends GrantedAuthority> authorities, String userEmail, String userAddr, String userBirth) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

        this.userEmail = userEmail;
        this.userAddr = userAddr;
        this.userBirth = userBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }
}
