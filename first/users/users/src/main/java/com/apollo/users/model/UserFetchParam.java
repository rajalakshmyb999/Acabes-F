package com.apollo.users.model;

import com.apollo.users.model.enums.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFetchParam {
    private String userId;
    private UserType userType;
    private String phone;
    private String email;
    private Integer page;
    private Integer size;
}
