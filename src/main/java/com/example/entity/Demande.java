package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demande extends BaseEntity {
   

    private String justificatif;
    private String commentaire;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("demandes")
    private User user;
    @Column(columnDefinition = "varchar(30) default 'attente'")
    private String etat;
}
