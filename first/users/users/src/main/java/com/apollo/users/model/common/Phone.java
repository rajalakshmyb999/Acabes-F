package com.apollo.users.model.common;

import com.apollo.users.model.enums.PhoneType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private PhoneType phoneType;

   @NotBlank(message = "Number is required")
    private String number;
}
