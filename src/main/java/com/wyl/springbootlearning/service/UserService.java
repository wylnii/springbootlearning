package com.wyl.springbootlearning.service;

import com.wyl.springbootlearning.domain.User;
import com.wyl.springbootlearning.exception.UserException;
import com.wyl.springbootlearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 统一异常处理
     *
     * @param id
     */
    public void getUsername(Integer id) {
        User user = userRepository.findOne(id);
        String name = user.getUsername();
        if (name.length() < 3) {
            throw new UserException(-1, "name.length() < 3");
        } else if (name.length() < 8) {
            throw new UserException(-2, "name.length() < 8");
        }
    }
}
