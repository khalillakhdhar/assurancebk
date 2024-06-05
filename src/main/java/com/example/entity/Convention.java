package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Convention extends BaseEntity{
 

    private long nombreEnregistrement;
    private Date dateInscription;
    private Date dateDebutConvention;
    private Date dateFinConvention;

    @Enumerated(EnumType.STRING)
    private Materiel materiel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("conventions")
    private User user;
}


