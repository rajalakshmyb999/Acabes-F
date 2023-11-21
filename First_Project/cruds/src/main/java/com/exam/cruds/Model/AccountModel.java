package com.exam.cruds.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserData")
public class AccountModel
{




    private String name;
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
