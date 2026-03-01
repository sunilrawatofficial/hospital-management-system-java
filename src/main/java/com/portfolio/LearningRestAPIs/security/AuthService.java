package com.portfolio.LearningRestAPIs.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.portfolio.LearningRestAPIs.admin.dto.LoginRequestDto;
import com.portfolio.LearningRestAPIs.admin.dto.LoginResponseDto;
import com.portfolio.LearningRestAPIs.admin.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication =   authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(user.getId(), user.getUsername(), token);
    }
}
