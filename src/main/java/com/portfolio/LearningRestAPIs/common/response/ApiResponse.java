package com.portfolio.LearningRestAPIs.common.response;

public record  ApiResponse<T>(int status, T data) {}
