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

    @Column(nullable = false)
    public String password;

    @Column
    public String name;

    @Column
    public String cep;

    @Column
    public String address;

    @Lob
    public String openField;

    @Lob
    public String inforBottomSheet; // Dados do bottom sheet

    @Column(nullable = false)
    public LocalDateTime createdAt = LocalDateTime.now();
}
