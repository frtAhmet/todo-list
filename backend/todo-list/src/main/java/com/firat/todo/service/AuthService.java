package com.firat.todo.service;

import com.firat.todo.dto.LoginDto;
import com.firat.todo.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
