package com.atesteme.entity;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends PanacheEntity {
     @Column(nullable = false, unique = true)
    public String email;

    @Column(length = 255, nullable = false)
    public String password;

    @Column
    public String name;

    @Column
    public String cep;

    @Lob
    public String openField;

    @Lob
    public String inforBottomSheet; // Dados do bottom sheet

    @Column(nullable = false)
    public LocalDateTime createdAt = LocalDateTime.now();

    // --- Getters e Setters ---

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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getInforBottomSheet() {
        return inforBottomSheet;
    }
    public void setInforBottomSheet(String inforBottomSheet) {
        this.inforBottomSheet = inforBottomSheet;
    }

    public String getOpenField() {
        return openField;
    }
    public void setOpenField(String openField) {
        this.openField = openField;
    }
}
