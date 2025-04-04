package com.example.reclamation;

import com.example.reclamation.Reclamation;
import com.example.reclamation.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    // Ajouter une réclamation
    @PostMapping
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        return ResponseEntity.ok(reclamationService.addReclamation(reclamation));
    }

    // Modifier une réclamation
    @PutMapping("/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamation) {
        return ResponseEntity.ok(reclamationService.updateReclamation(id, reclamation));
    }

    // Supprimer une réclamation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReclamation(@PathVariable Long id) {
        return ResponseEntity.ok(reclamationService.deleteReclamation(id));
    }

    // Afficher toutes les réclamations
    @GetMapping
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        return ResponseEntity.ok(reclamationService.getAllReclamations());
    }
}

