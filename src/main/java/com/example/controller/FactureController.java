package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Facture;
import com.example.service.FactureService;

import java.util.List;

@RestController
@RequestMapping("/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures() {
        return ResponseEntity.ok(factureService.getAllFactures());
    }


@GetMapping("/{id}")
public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
    return ResponseEntity.ok(factureService.getFactureById(id));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
    factureService.deleteFacture(id);
    return ResponseEntity.ok().build();
}
}
