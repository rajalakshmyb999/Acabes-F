package com.apollo.users.model.dto;

import com.apollo.users.model.common.AdditionalProperties;
import com.apollo.users.model.common.Address;
import com.apollo.users.model.common.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    private Name name;
    private Address address;
    private AdditionalProperties additionalProperties;
}
