package com.NewUser.service;


import com.NewUser.entity.User;
import com.NewUser.payload.UserDto;
import com.NewUser.repository.UserRepository;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
      UserDto newUserDto = mapToDto(newUser);
      return newUserDto;

    }




    User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setGender(userDto.getGender());
        return user;

    }

    UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setGender(user.getGender());
        return userDto;
    }


}