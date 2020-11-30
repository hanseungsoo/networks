package io.human.networks.repository.custom.impl;

import io.human.networks.entity.User;
import io.human.networks.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(User user) {
        entityManager.persist(user);
    }
}
