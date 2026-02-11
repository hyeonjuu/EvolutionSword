package com.evolution.sword.repository;

import com.evolution.sword.domain.user.UserItem;

import java.util.Optional;

public interface UserItemRepository {
    UserItem save(UserItem userItem);
    Optional<UserItem> findById(Long id);
    Optional<UserItem> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
