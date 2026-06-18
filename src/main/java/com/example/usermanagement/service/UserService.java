package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.UserEntity;

public interface UserService {

    UserEntity createUser(UserDto dto);

    UserEntity updateUser(Long id,UserDto dto);

}
