package com.evolution.sword.repository;

import com.evolution.sword.domain.user.UserItem;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaUserItemRepository implements UserItemRepository{

    private final EntityManager em;

    @Autowired
    public JpaUserItemRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public UserItem save(UserItem userItem) {
        em.persist(userItem);
        return userItem;
    }

    @Override
    public Optional<UserItem> findById(Long id) {
        return Optional.ofNullable(em.find(UserItem.class,id));
    }

    @Override
    public Optional<UserItem> findByUserId(Long userId) {
        List<UserItem> result = em.createQuery("select ui from UserItem ui where ui.user.id = :userId",UserItem.class)
                .setParameter("userId",userId)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public void deleteByUserId(Long userId) {
        em.createQuery("delete from UserItem ui where ui.user.id = :userId")
                .setParameter("userId",userId)
                .executeUpdate();
    }
}
