package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Convention;
import com.example.repository.ConventionRepository;

import java.util.List;

@Service
public class ConventionService {

    @Autowired
    private ConventionRepository conventionRepository;

    public List<Convention> getAllConventions() {
        return conventionRepository.findAll();
    }

    public Convention getConventionById(Long id) {
        return conventionRepository.findById(id).orElseThrow(() -> new RuntimeException("Convention not found"));
    }

    public void deleteConvention(Long id) {
        conventionRepository.deleteById(id);
    }
}
