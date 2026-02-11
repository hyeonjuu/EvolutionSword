package com.evolution.sword.domain.user;

import com.evolution.sword.domain.ItemMetadata;
import jakarta.persistence.*;

@Entity
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
