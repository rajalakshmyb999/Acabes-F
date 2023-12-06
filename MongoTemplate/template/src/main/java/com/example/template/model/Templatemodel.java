package com.example.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Template")
public class Templatemodel {
    @Id
    private String id;
    private String getId() { return id; }
    public void setId(String id) { this.id = id; }
    private Integer accountid;
    private String name;

    @JsonProperty("accountid")
    public Integer getAccountid() { return accountid; }
    public void setAccountid(Integer accountid) { this.accountid = accountid; }
    @JsonProperty("name")
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
