package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Convention;

public interface ConventionRepository extends JpaRepository<Convention, Long> {

}
