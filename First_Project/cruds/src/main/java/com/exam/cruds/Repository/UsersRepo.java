package com.exam.cruds.Repository;

import com.exam.cruds.Model.UserData;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface  UsersRepo extends MongoRepository<UserData,String> {



}
