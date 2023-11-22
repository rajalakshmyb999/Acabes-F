package com.apollo.users.model.dto;

import com.apollo.users.model.common.AdditionalProperties;
import com.apollo.users.model.common.Name;
import com.apollo.users.model.common.Phone;
import com.apollo.users.model.enums.UserType;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private String userId;
    private Name name;
    private List<Phone> phone;
    private String email;
    private UserType userType;
    private AdditionalProperties additionalProperties;
}
