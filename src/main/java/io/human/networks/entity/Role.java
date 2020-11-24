package io.human.networks.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column
    private String roleName;
}
