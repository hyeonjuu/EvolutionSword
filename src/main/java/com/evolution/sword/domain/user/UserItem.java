package com.evolution.sword.domain.user;

import com.evolution.sword.domain.ItemMetadata;
import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

import java.time.LocalDateTime;

@Entity
@SoftDelete(strategy = SoftDeleteType.TIMESTAMP,columnName = "deleted_at")
public class UserItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_id")
    private ItemMetadata itemMetadata;

    private Integer currentLevel;

}
