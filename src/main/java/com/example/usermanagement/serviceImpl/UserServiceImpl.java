package com.example.usermanagement.serviceImpl;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.UserEntity;
import com.example.usermanagement.repository.UserRepository;
import com.example.usermanagement.service.UserService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public UserEntity createUser(UserDto dto) {

        repository.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new ValidationException("Email Already exits");
        });

        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());


        return repository.save(user);
    }

    @Override
    public UserEntity updateUser(Long id, UserDto dto) {

        repository.findByEmail(dto.getEmail()).ifPresent(u -> {
            throw new ValidationException("Email Already exits");
        });

        UserEntity user = repository.findById(id).orElseThrow(() ->
                new ValidationException("User not found with id" + id));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        return repository.save(user);
    }
}
