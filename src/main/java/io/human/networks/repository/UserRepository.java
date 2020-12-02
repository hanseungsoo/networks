package io.human.networks.repository;

import io.human.networks.entity.User;
import io.human.networks.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    public User findByUserId(String userId);
}
