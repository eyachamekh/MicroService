package com.example.reclamation;

import com.example.reclamation.Reclamation;
import com.example.reclamation.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    // Ajouter une réclamation
    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    // Modifier une réclamation
    public Reclamation updateReclamation(Long id, Reclamation newReclamation) {
        Optional<Reclamation> optionalReclamation = reclamationRepository.findById(id);
        if (optionalReclamation.isPresent()) {
            Reclamation existingReclamation = optionalReclamation.get();
            existingReclamation.setClientNom(newReclamation.getClientNom());
            existingReclamation.setProduit(newReclamation.getProduit());
            existingReclamation.setMessage(newReclamation.getMessage());
            existingReclamation.setStatut(newReclamation.getStatut());
            return reclamationRepository.save(existingReclamation);
        }
        return null;
    }

    // Supprimer une réclamation
    public String deleteReclamation(Long id) {
        if (reclamationRepository.existsById(id)) {
            reclamationRepository.deleteById(id);
            return "Réclamation supprimée avec succès.";
        }
        return "Réclamation introuvable.";
    }

    // Afficher toutes les réclamations
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }
}

