package com.dj.spring.boot.ollama.local.service;

import jakarta.validation.constraints.NotBlank;

public record Question(@NotBlank(message = "Question is required") String question) {}
