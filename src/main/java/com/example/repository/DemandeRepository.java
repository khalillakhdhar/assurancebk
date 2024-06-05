package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

}
