package com.portfolio.LearningRestAPIs.admin.repository;

import com.portfolio.LearningRestAPIs.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
}
