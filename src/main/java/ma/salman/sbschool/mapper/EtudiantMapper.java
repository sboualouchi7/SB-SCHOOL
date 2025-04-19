package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.EtudiantDTO;
import ma.salman.sbschool.Models.Classe;
import ma.salman.sbschool.Models.Etudiant;
import ma.salman.sbschool.Models.Parent;
import ma.salman.sbschool.repository.ClasseRepository;
import ma.salman.sbschool.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EtudiantMapper {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ParentRepository parentRepository;

    // Conversion Etudiant → EtudiantDTO
    public EtudiantDTO toDto(Etudiant etudiant) {
        if (etudiant == null) {
            return null;
        }

        EtudiantDTO dto = new EtudiantDTO();
        dto.setId(etudiant.getId());
        dto.setNom(etudiant.getNom());
        dto.setPrenom(etudiant.getPrenom());
        dto.setEmail(etudiant.getEmail());
        dto.setDateInscription(etudiant.getDateInscription());
        dto.setFiliere(etudiant.getFiliere());

        // Gestion des relations
        dto.setClasseId(etudiant.getClasse() != null ? etudiant.getClasse().getId() : null);
        dto.setParentId(etudiant.getParent() != null ? etudiant.getParent().getId() : null);

        return dto;
    }

    // Conversion EtudiantDTO → Etudiant
    public Etudiant toEntity(EtudiantDTO dto) {
        if (dto == null) {
            return null;
        }

        Etudiant etudiant = new Etudiant();
        updateEntityFromDto(dto, etudiant);
        return etudiant;
    }

    // Mise à jour d'une entité existante
    public void updateEntityFromDto(EtudiantDTO dto, Etudiant entity) {
        if (dto == null || entity == null) {
            return;
        }

        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setEmail(dto.getEmail());
        entity.setDateInscription(dto.getDateInscription());
        entity.setFiliere(dto.getFiliere());

        // Gestion des relations
        entity.setClasse(dto.getClasseId() != null ?
                classeRepository.findById(dto.getClasseId()).orElse(null) : null);

        entity.setParent(dto.getParentId() != null ?
                parentRepository.findById(dto.getParentId()).orElse(null) : null);

        // Les collections sont ignorées comme dans votre version originale
    }

    // Conversion de liste
    public List<EtudiantDTO> toDtoList(List<Etudiant> etudiants) {
        return etudiants.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}