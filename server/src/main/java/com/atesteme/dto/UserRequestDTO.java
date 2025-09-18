package com.atesteme.dto;

import com.atesteme.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve ter ao menos 8 caracteres")
    @Pattern(
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).*$",
      message = "Senha precisa conter maiúscula, minúscula, número e caractere especial"
    )
    private String password;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP inválido")
    private String cep;

    private String inforBottomSheet;

    private String openField;

    // Getters e Setters
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

    // Método utilitário: converte DTO -> entidade User
    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password); // ⚠️ Hash a senha antes de persistir!
        user.setCep(this.cep);
        user.setInforBottomSheet(this.inforBottomSheet);
        user.setOpenField(this.openField);
        return user;
    }
}
