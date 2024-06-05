package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Demande;
import com.example.repository.DemandeRepository;

import java.util.List;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;
    public Demande addDemande(Demande demande)
    {
    	return demandeRepository.save(demande);
    }

    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Demande not found"));
    }

    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }
}
