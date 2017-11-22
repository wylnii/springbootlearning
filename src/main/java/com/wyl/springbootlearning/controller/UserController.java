package com.wyl.springbootlearning.controller;

import com.wyl.springbootlearning.domain.Result;
import com.wyl.springbootlearning.domain.User;
import com.wyl.springbootlearning.repository.UserRepository;
import com.wyl.springbootlearning.service.UserService;
import com.wyl.springbootlearning.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public Result addUser(@Valid User user, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(-1, bindingResult.getFieldError().getDefaultMessage());
        } else {
            return ResultUtil.success(user);
        }
    }

    @GetMapping("/{id}")
    public Object findUserById(@PathVariable("id") Integer id) {
        User user = userRepository.findOne(id);
        if (user != null)
            return user;
        else
            return "user: " + id + " is not exist";
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Integer id,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password) {
        User user = userRepository.findOne(id);
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delUserById(@PathVariable("id") Integer id) {
        User user = userRepository.findOne(id);
        if (user != null)
            userRepository.delete(user);
    }

    @GetMapping("/name/{username}")
    public List<User> findUserByUsername(@PathVariable("username") String username) {
        return userRepository.findUserByUsername(username);
    }

    @GetMapping("/getname/{id}")
    public void getName(@PathVariable("id") Integer id) {
        userService.getUsername(id);
    }
}
