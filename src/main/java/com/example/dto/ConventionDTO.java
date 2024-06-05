package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import com.example.entity.Materiel;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConventionDTO extends BaseDTO{
    private int idConv;
    private long nombreEnregistrement;
    private Date dateInscription;
    private Date dateDebutConvention;
    private Date dateFinConvention;
    private Materiel materiel;
}
