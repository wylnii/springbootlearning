package com.wyl.springbootlearning.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void getAllUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user"))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addUser() throws Exception {
    }

    @Test
    public void findUserById() throws Exception {
    }

    @Test
    public void updateUserById() throws Exception {
    }

    @Test
    public void delUserById() throws Exception {
    }

    @Test
    public void findUserByUsername() throws Exception {
    }

    @Test
    public void getName() throws Exception {
    }

}