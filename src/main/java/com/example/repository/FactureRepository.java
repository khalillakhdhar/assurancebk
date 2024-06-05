package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
