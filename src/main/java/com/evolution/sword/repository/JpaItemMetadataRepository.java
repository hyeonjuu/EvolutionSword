package com.evolution.sword.repository;

import com.evolution.sword.domain.ItemMetadata;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaItemMetadataRepository implements ItemMetadataRepository{

    @Autowired
    private final EntityManager em;

    public JpaItemMetadataRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Optional<ItemMetadata> findByItemPath_PathCodeAndEnhancementLevel(String pathCode, Integer level) {
        String jpql = "select im from ItemMetadata im " +
                "join im.itemPath ip " +
                "where ip.pathCode = :pathCode and im.enhancementLevel = :level";

        return em.createQuery(jpql,ItemMetadata.class)
                .setParameter("pathCode",pathCode)
                .setParameter("level",level)
                .getResultList()
                .stream()
                .findAny();
    }

}
