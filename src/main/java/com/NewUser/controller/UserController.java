package com.NewUser.controller;
import com.NewUser.payload.UserDto;
import com.NewUser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {


       private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/api/users
    @RequestMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto newuserDto= userService.createUser(userDto);
          return new ResponseEntity<>(newuserDto,HttpStatus.CREATED);
      }

}
