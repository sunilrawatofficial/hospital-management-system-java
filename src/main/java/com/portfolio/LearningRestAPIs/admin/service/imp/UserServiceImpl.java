package com.portfolio.LearningRestAPIs.admin.service.imp;

import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.admin.entity.User;
import com.portfolio.LearningRestAPIs.admin.repository.UserRepository;
import com.portfolio.LearningRestAPIs.admin.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private  final UserRepository userRepository;
  @Override
  public User findByUsername(String username) {
     return userRepository.findByUsername(username)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
  };
  
}
