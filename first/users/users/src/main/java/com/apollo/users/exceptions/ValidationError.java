package com.apollo.users.exceptions;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class ValidationError {
    private List<String> errors;

}
