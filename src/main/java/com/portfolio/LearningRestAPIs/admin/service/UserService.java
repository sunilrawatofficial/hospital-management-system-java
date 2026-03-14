package com.portfolio.LearningRestAPIs.admin.service;

import com.portfolio.LearningRestAPIs.admin.entity.User;

public interface  UserService {
  User findByUsername(String username);
}
