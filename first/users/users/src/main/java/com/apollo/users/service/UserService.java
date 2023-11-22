package com.apollo.users.service;

import com.apollo.users.entitiy.UserEntity;
import com.apollo.users.model.UserFetchParam;
import com.apollo.users.model.dto.UpdateUserDto;
import com.apollo.users.model.dto.UserRequestDto;
import com.apollo.users.model.dto.UserResponseDto;
import com.apollo.users.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    @Autowired
    ModelMapper modelMapper;



    @SneakyThrows
    public UserResponseDto create(@Valid UserRequestDto userRequestDto) {
        UserEntity user = modelMapper.map(userRequestDto, UserEntity.class);
        if(Objects.isNull(user.getAddress().getStreet()) && Objects.isNull(user.getAddress().getArea())
                && Objects.isNull(user.getAddress().getLandmark())
                && Objects.isNull(user.getAddress().getBuilding())){
                throw new RuntimeException("Either street or area or landmark or building required");
        }
        user.setUserId(UUID.randomUUID().toString());
        return modelMapper.map(userRepository.insert(user), UserResponseDto.class);

    }


    public List<UserResponseDto> fetch(UserFetchParam userFetchParam) {
        Pageable pageable = PageRequest.of(userFetchParam.getPage(), userFetchParam.getSize());
        Query query = new Query();

        if(Objects.nonNull(userFetchParam.getUserId())){
            query.addCriteria(Criteria.where("userId").is(userFetchParam.getUserId()));
        }
        if(Objects.nonNull(userFetchParam.getUserType())){
            query.addCriteria(Criteria.where("userType").is(userFetchParam.getUserType()));
        }
        if(Objects.nonNull(userFetchParam.getPhone())){
            query.addCriteria(Criteria.where("phone.number").is(userFetchParam.getPhone()));
        }
        if(Objects.nonNull(userFetchParam.getEmail())){
            query.addCriteria(Criteria.where("email").is(userFetchParam.getEmail()));
        }
        query.with(pageable);
        List<UserEntity> users = mongoTemplate.find(query, UserEntity.class);
        Page<UserEntity> page = PageableExecutionUtils.getPage(
                users,
                pageable,
                () -> mongoTemplate.count(query, UserEntity.class));
        return page.stream().map(userEntity -> modelMapper.map(userEntity, UserResponseDto.class))
                .collect(Collectors.toList());


    }

    public UpdateUserDto update(String userId, UserRequestDto userRequestDto) {
        UserEntity oldUser = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        modelMapper.map(userRequestDto, oldUser);
        return modelMapper.map(userRepository.save(oldUser), UpdateUserDto.class);

    }

    public HashMap<String , String > delete(String userId) {
        HashMap<String, String> result = new HashMap<>();
        if(userRepository.existsById(userId)){
            userRepository.deleteById(userId);
            result.put("status","SUCCESS");
        }
        else {
            result.put("status", "FAILED");
        }
        return result;

    }



}
