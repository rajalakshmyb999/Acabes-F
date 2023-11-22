package com.apollo.users.repository;

import com.apollo.users.entitiy.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

}
