package com.evolution.sword.global.config;

import com.evolution.sword.repository.JpaUserRepository;
import com.evolution.sword.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
    private EntityManager em;

    @Autowired
    public JpaConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }
}
