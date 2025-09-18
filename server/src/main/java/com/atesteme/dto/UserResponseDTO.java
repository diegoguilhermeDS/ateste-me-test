package com.atesteme.dto;

import com.atesteme.entity.User;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;

    // Construtor a partir da entidade User
    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.id;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
