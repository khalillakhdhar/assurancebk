package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DemandeDTO extends BaseDTO{
    private int idDemande;
    private String justificatif;
    private String commentaire;
    private Date dateCreation;
}
