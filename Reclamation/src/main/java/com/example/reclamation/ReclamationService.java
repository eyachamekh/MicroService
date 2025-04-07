package com.example.reclamation;

import com.example.reclamation.Reclamation;
import com.example.reclamation.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ReclamationService {

    @Value("${file.upload-dir}")
    private String uploadDir;


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

    public Reclamation addReclamationWithFile(Reclamation reclamation, MultipartFile file) {
        try {
            // Sauvegarder le fichier
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(uploadDir + File.separator + fileName);
            Files.write(path, file.getBytes());

            // Sauvegarder le nom du fichier dans la réclamation
            reclamation.setFileName(fileName);

            return reclamationRepository.save(reclamation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

