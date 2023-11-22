package com.apollo.users.entitiy;


import com.apollo.users.model.common.AdditionalProperties;
import com.apollo.users.model.common.Address;
import com.apollo.users.model.common.Name;
import com.apollo.users.model.common.Phone;
import com.apollo.users.model.enums.UserType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
@Data
public class UserEntity {

    @Id
    private String userId;

    private Name name;
    private List<Phone> phone;
    private String email;
    private Address address;
    private UserType userType;
    private AdditionalProperties additionalProperties;



}
