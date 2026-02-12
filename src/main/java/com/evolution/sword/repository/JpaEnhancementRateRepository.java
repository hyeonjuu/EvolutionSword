package com.evolution.sword.repository;

import com.evolution.sword.domain.EnhancementRate;
import com.evolution.sword.domain.ItemType;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaEnhancementRateRepository implements EnhancementRateRepository{

    private final EntityManager em;

    @Autowired
    public JpaEnhancementRateRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public EnhancementRate save(EnhancementRate enhancementRate) {
        em.persist(enhancementRate);
        return enhancementRate;
    }

    @Override
    public Optional<EnhancementRate> findByItemTypeAndTargetLevel(ItemType itemType, Integer targetLevel) {
        return em.createQuery("select er from EnhancementRate er where er.itemType = :itemType and er.targetLevel = :targetLevel",EnhancementRate.class)
                .setParameter("itemType",itemType)
                .setParameter("targetLevel",targetLevel)
                .getResultList()
                .stream()
                .findAny();

    }
}
