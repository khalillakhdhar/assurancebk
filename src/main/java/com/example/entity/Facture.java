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
public class Facture extends BaseEntity {

    private float nombreFacture;
    private Date dateFacturation;
    private float montantFacturation;
    private String rib;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("factures")
    private User user;
}
