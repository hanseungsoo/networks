package io.human.networks.repository;

import io.human.networks.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRoleName(String name);
}
