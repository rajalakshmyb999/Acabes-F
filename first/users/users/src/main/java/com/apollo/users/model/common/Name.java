package com.apollo.users.model.common;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    @NotBlank(message = "Firstname is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Lastname is required")
    private String lastName;
}
