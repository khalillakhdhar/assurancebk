package com.example.dto;

import com.example.entity.Adresse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {
    @NotBlank
    private String nom;
    
    @NotBlank
    private String prenom;
    
    @NotBlank
    @Email
    private String email;
    
    @JsonIgnoreProperties(allowSetters = true, value = "password")
    @NotBlank
    @Size(min = 8)
    private String password;
    
    private String telephonePortable;
    private String telephoneFixe;
    private String genre;
    private String role;
    private String matriculeMedecine;
    private Adresse adresse;
}
