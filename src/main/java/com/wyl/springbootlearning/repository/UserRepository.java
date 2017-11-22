package com.wyl.springbootlearning.repository;

import com.wyl.springbootlearning.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findUserByUsername(String username);
}
