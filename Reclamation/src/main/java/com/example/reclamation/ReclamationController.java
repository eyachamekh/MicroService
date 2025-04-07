package com.example.reclamation;

import com.example.reclamation.Reclamation;
import com.example.reclamation.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    // Ajouter une réclamation
    @PostMapping("add")
    public ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation) {
        return ResponseEntity.ok(reclamationService.addReclamation(reclamation));
    }

    // Ajouter une réclamation avec un fichier
    @PostMapping("/addWithFile")
    public ResponseEntity<Reclamation> createReclamationWithFile(
            @RequestParam("clientNom") String clientNom,
            @RequestParam("produit") String produit,
            @RequestParam("message") String message,
            @RequestParam("statut") String statut,
            @RequestParam("file") MultipartFile file) {

        Reclamation reclamation = new Reclamation(clientNom, produit, message, statut);
        Reclamation savedReclamation = reclamationService.addReclamationWithFile(reclamation, file);

        return ResponseEntity.ok(savedReclamation);
    }


    // Modifier une réclamation
    @PutMapping("/update/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamation) {
        return ResponseEntity.ok(reclamationService.updateReclamation(id, reclamation));
    }

    // Supprimer une réclamation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReclamation(@PathVariable Long id) {
        return ResponseEntity.ok(reclamationService.deleteReclamation(id));
    }

    // Afficher toutes les réclamations
    @GetMapping
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        return ResponseEntity.ok(reclamationService.getAllReclamations());
    }
}

