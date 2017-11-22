package com.wyl.springbootlearning;

import com.wyl.springbootlearning.domain.User;
import com.wyl.springbootlearning.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    public void getUsername() throws Exception {
        userService.getUsername(2);
        assertEquals(1,1);
    }

}