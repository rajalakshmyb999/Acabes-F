package com.apollo.users.model.dto;

import com.apollo.users.model.common.AdditionalProperties;
import com.apollo.users.model.common.Address;
import com.apollo.users.model.common.Name;
import com.apollo.users.model.common.Phone;
import com.apollo.users.model.enums.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {

    @Valid
    private Name name;

    @Valid
    private List<Phone> phone;

    @NotBlank(message = "Email address cannot be empty")
    private String email;

    @Valid
    private Address address;
    private UserType userType;
    private AdditionalProperties additionalProperties;
}
