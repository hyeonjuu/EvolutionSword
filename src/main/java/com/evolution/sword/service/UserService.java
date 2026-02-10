package com.evolution.sword.service;

import com.evolution.sword.domain.user.User;
import com.evolution.sword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(User user){
        validateDuplicateUser(user);

        user.setGold(60000L);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user){
        userRepository.findByUsername(user.getUsername())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<User> findUsers(){return userRepository.findAll();}

    public Optional<User> findOne(Long findId){
        return userRepository.findById(findId);
    }

}
