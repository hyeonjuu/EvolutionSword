package com.evolution.sword.repository;

import com.evolution.sword.domain.EnhancementRate;
import com.evolution.sword.domain.ItemType;

import java.util.Optional;

public interface EnhancementRateRepository {
    EnhancementRate save(EnhancementRate enhancementRate);
    Optional<EnhancementRate> findByItemTypeAndTargetLevel(ItemType itemType, Integer targetLevel);
}
