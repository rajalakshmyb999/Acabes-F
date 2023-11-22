package com.apollo.users.controller;


import com.apollo.users.exceptions.ValidationError;
import com.apollo.users.model.UserFetchParam;
import com.apollo.users.model.dto.UpdateUserDto;
import com.apollo.users.model.dto.UserRequestDto;
import com.apollo.users.model.dto.UserResponseDto;
import com.apollo.users.model.enums.UserType;
import com.apollo.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/users/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/filtered")
    public List<UserResponseDto> getUsers( @RequestParam(name = "userId", required = false) String userId,
                                          @RequestParam(name = "userType", required = false) UserType userType,
                                          @RequestParam(name = "phone", required = false) String phone,
                                          @RequestParam(name = "email", required = false) String email,
                                           @RequestParam(name = "page" ,required = false, defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", required = false, defaultValue = "2") Integer size ){
        return userService.fetch(UserFetchParam.builder()
                .userId(userId)
                .userType(userType)
                .phone(phone)
                .email(email)
                .page(page)
                .size(size)
                .build());
    }

    @PostMapping()
    public UserResponseDto postUser(@Valid @RequestBody UserRequestDto userRequestDto) throws Exception {
        return userService.create(userRequestDto);
    }

    @PutMapping("/{userId}")
    public UpdateUserDto putUser(@PathVariable("userId") String userId, @Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.update(userId,userRequestDto);
    }

    @DeleteMapping("/{userId}")
    public HashMap<String, String> deleteUser(@PathVariable("userId") String userId) {
        return userService.delete(userId);
    }
    @ExceptionHandler({ RuntimeException.class })
    public ValidationError handleException(RuntimeException exception) {
        return ValidationError.builder().errors(List.of(exception.getMessage())).build();
    }



}
