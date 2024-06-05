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
public class FactureDTO extends BaseDTO{
    private int idFacture;
    private float nombreFacture;
    private Date dateFacturation;
    private float montantFacturation;
    private String rib;
}
