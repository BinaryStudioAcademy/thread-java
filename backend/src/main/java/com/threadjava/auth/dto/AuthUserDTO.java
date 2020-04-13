package com.threadjava.auth.dto;

import com.threadjava.users.dto.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDTO {
    private String token;
    private UserShortDto user;
}