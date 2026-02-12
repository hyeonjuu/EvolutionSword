package com.evolution.sword.repository;

import com.evolution.sword.domain.ItemMetadata;

import java.util.Optional;

public interface ItemMetadataRepository {
    Optional<ItemMetadata> findByItemPath_PathCodeAndEnhancementLevel(String pathCode,Integer enhancementLevel);
}
