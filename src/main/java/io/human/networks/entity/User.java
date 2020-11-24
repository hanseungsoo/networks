package io.human.networks.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String userName;

    @Column
    private String userEmail;

    @Column
    private String userAddr;

    @Column
    private String userBirth;

    @Column
    private boolean enabled;

    @Column
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
