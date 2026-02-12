package com.evolution.sword.domain.user;

import com.evolution.sword.domain.ItemMetadata;
import com.evolution.sword.domain.ItemType;
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

    private ItemType itemType;
    private Integer currentLevel;

    protected UserItem() {}

    public UserItem(Builder builder){
        this.user = builder.user;
        this.itemMetadata = builder.itemMetadata;
        this.itemType = builder.itemType;
        this.currentLevel = builder.currentLevel;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void upgrade(ItemMetadata itemMetadata){
        this.itemMetadata = itemMetadata;
        this.currentLevel = itemMetadata.getEnhancementLevel();
    }

    public Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private User user;
        private ItemMetadata itemMetadata;
        private ItemType itemType;
        private Integer currentLevel;

        public Builder user(User user){
            this.user = user;
            return this;
        }
        public Builder itemMetadata(ItemMetadata itemMetadata){
            this.itemMetadata = itemMetadata;
            return this;
        }
        public Builder itemType(ItemType itemType){
            this.itemType = itemType;
            return this;
        }
        public Builder currentLevel(Integer currentLevel){
            this.currentLevel = currentLevel;
            return this;
        }

        public UserItem build(){
            return new UserItem(this);
        }
    }

    public static UserItem createBaseItem(User user, ItemMetadata metadata){
        return new Builder()
                .user(user)
                .itemMetadata(metadata)
                .itemType(metadata.getItemType())
                .currentLevel(0)
                .build();
    }

}
