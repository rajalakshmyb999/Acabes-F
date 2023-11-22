package com.apollo.users.model.common;

import com.apollo.users.model.enums.UserType;
import lombok.Data;

import java.util.HashMap;


@Data
public class AdditionalProperties {
    private UserType userType;
    private HashMap<String,String> additionalProperty;

}