package com.shopping.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

    int id;
    String name;
    String description;

    public Category(){}

    public Category(@JsonProperty("id") int id,
                    @JsonProperty("name") String name,
                    @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
