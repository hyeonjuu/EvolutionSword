package com.evolution.sword.service;

import com.evolution.sword.domain.EnhancementRate;
import com.evolution.sword.domain.ItemMetadata;
import com.evolution.sword.domain.user.User;
import com.evolution.sword.domain.user.UserItem;
import com.evolution.sword.exception.EntityNotFoundException;
import com.evolution.sword.exception.MaxLevelReachedException;
import com.evolution.sword.repository.EnhancementRateRepository;
import com.evolution.sword.repository.ItemMetadataRepository;
import com.evolution.sword.repository.UserItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserItemService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserItemRepository userItemRepository;

    @Autowired
    private EnhancementRateRepository enhancementRateRepository;

    @Autowired
    private ItemMetadataRepository itemMetadataRepository;

    public void giveItem(Long userId, UserItem userItem){
        takeItem(userId);

        //아이템을 유저에게 제공
        userItemRepository.save(userItem);
    }
    public void takeItem(Long userId){
        //아이템을 회수
        userItemRepository.deleteByUserId(userId);
    }

    public void giveBaseItem(Long userId){
        ItemMetadata baseMetadata = itemMetadataRepository.findByItemPath_PathCodeAndEnhancementLevel("S_DEFAULT",0)
                .orElseThrow(()->new EntityNotFoundException("기본 아이템 정보를 찾을 수 없습니다."));
        User user = userService.findOne(userId).orElseThrow(EntityNotFoundException::new);

        UserItem baseItem = UserItem.createBaseItem(user,baseMetadata);
        giveItem(userId,baseItem);
    }

    public UserItem upgrade(Long userId){
        // 1. user, userItem 조회
        User user = userService.findOne(userId).orElseThrow(()-> new EntityNotFoundException("사용자를 찾을 수 없습니다."));
        UserItem userItem = userItemRepository.findByUserId(userId).orElseThrow(()->{
            //giveBaseItem(userId);
            return new EntityNotFoundException("강화할 아이템이 없습니다.");
        });

        //2. 강화 설정 조회 Exception 변경 필요
        EnhancementRate rateInfo = enhancementRateRepository.findByItemTypeAndTargetLevel(userItem.getItemType(),userItem.getCurrentLevel()+1)
                .orElseThrow(MaxLevelReachedException::new);

        //3. 골드 확인
        user.useGold(rateInfo.getCost());

        double randomRate = Math.random();
        if(randomRate < rateInfo.getSuccessRate()){ // 강화 성공시
            ItemMetadata nextItemMetadata = getNextItemMetadata(userItem);
            userItem.upgrade(nextItemMetadata);
        }
        return userItem;
    }

    public ItemMetadata getNextItemMetadata(UserItem userItem){
        //실제론 현재 아이템의 다음 메타데이터를 조회
        return new ItemMetadata();

    }

}
