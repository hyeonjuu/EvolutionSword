package com.evolution.sword.service;

import com.evolution.sword.domain.user.User;
import com.evolution.sword.domain.user.UserDto;
import com.evolution.sword.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입(){
        UserDto dto = new UserDto();
        dto.setUsername("현주");
        User user = dto.toEntity();

        Long saveId = userService.join(user);

        User findUser = userService.findOne(saveId).get();

        Assertions.assertThat(user.getUsername()).isEqualTo(findUser.getUsername());

    }

    @Test
    public void 중복_회원가입(){
        UserDto dto = new UserDto();
        dto.setUsername("현주");
        User user = dto.toEntity();

        Long saveId = userService.join(user);

        UserDto dto2 = new UserDto();
        dto2.setUsername("현주");
        User user2 = dto2.toEntity();

        IllegalStateException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class,()->userService.join(user2));
        e.printStackTrace();
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
