package com.exam.cruds.Repository;

import com.exam.cruds.Model.AccountModel;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface AccountRepository extends MongoRepository<AccountModel,String >{
    public AccountModel findByaccountid(int accountid);

}

