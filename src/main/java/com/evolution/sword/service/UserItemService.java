package com.evolution.sword.service;

import com.evolution.sword.domain.user.User;
import com.evolution.sword.domain.user.UserItem;
import com.evolution.sword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserItemService {

    public void giveItem(Long userId, UserItem userItem){
        takeItem(userId);

        //아이템을 유저에게 제공

    }
    public void takeItem(Long userId){
        //아이템을 회수

    }

    public void giveBaseItem(Long userId){

    }

}
