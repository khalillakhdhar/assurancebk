package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Facture;
import com.example.repository.FactureRepository;

import java.util.List;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
    }

    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }
}
