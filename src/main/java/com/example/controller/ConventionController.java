package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Convention;
import com.example.service.ConventionService;

import java.util.List;

@RestController
@RequestMapping("/conventions")
public class ConventionController {

    @Autowired
    private ConventionService conventionService;

    @GetMapping
    public ResponseEntity<List<Convention>> getAllConventions() {
        return ResponseEntity.ok(conventionService.getAllConventions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convention> getConventionById(@PathVariable Long id) {
        return ResponseEntity.ok(conventionService.getConventionById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConvention(@PathVariable Long id) {
        conventionService.deleteConvention(id);
        return ResponseEntity.ok().build();
    }
}
