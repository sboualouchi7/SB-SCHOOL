package ma.salman.sbschool.mapper;


import ma.salman.sbschool.DTO.EvaluationDTO;
import ma.salman.sbschool.Models.Enseignant;
import ma.salman.sbschool.Models.Etudiant;
import ma.salman.sbschool.Models.Module;
import ma.salman.sbschool.Models.Evaluation;
import ma.salman.sbschool.repository.EnseignantRepository;
import ma.salman.sbschool.repository.EtudiantRepository;
import ma.salman.sbschool.repository.ModuleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EvaluationMapper {
    @Autowired
    protected EtudiantRepository etudiantRepository;

    @Autowired
    protected ModuleRepository moduleRepository;

    @Autowired
    protected EnseignantRepository enseignantRepository;

    @Mapping(target = "etudiantId", source = "etudiant.id")
    @Mapping(target = "moduleId", source = "module.id")
    @Mapping(target = "enseignantId", source = "enseignant.id")
    public abstract EvaluationDTO toDto(Evaluation evaluation);

    @Mapping(target = "etudiant", source = "etudiantId", qualifiedByName = "idToEtudiant")
    @Mapping(target = "module", source = "moduleId", qualifiedByName = "idToModule")
    @Mapping(target = "enseignant", source = "enseignantId", qualifiedByName = "idToEnseignant")
    public abstract Evaluation toEntity(EvaluationDTO evaluationDTO);

    public abstract List<EvaluationDTO> toDtoList(List<Evaluation> evaluations);

    @Mapping(target = "etudiant", source = "etudiantId", qualifiedByName = "idToEtudiant")
    @Mapping(target = "module", source = "moduleId", qualifiedByName = "idToModule")
    @Mapping(target = "enseignant", source = "enseignantId", qualifiedByName = "idToEnseignant")
    public abstract void updateEntityFromDto(EvaluationDTO dto, @MappingTarget Evaluation entity);

    @Named("idToEtudiant")
    protected Etudiant idToEtudiant(Long id) {
        if (id == null) return null;
        return etudiantRepository.findById(id).orElse(null);
    }

    @Named("idToModule")
    protected Module idToModule(Long id) {
        if (id == null) return null;
        return moduleRepository.findById(id).orElse(null);
    }

    @Named("idToEnseignant")
    protected Enseignant idToEnseignant(Long id) {
        if (id == null) return null;
        return enseignantRepository.findById(id).orElse(null);
    }
}
