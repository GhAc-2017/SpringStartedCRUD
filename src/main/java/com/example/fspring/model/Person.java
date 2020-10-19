package com.example.fspring.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class Person {
    private UUID uuid;
    private String name;

    public Person() {}

    public Person(@JsonProperty("id") UUID uuid, @JsonProperty("name") String name) {
        this.uuid = uuid;
        this.name = name;
    }

}
