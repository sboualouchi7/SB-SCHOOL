package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.ParentDTO;
import ma.salman.sbschool.Models.Etudiant;
import ma.salman.sbschool.Models.Parent;
import ma.salman.sbschool.repository.EtudiantRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ParentMapper {
    @Autowired
    protected EtudiantRepository etudiantRepository;

    @Mapping(target = "etudiantIds", source = "etudiants", qualifiedByName = "etudiantsToIds")
    public abstract ParentDTO toDto(Parent parent);

    @Mapping(target = "etudiants", source = "etudiantIds", qualifiedByName = "idsToEtudiants")
    public abstract Parent toEntity(ParentDTO parentDTO);

    public abstract List<ParentDTO> toDtoList(List<Parent> parents);

    @Mapping(target = "etudiants", source = "etudiantIds", qualifiedByName = "idsToEtudiants")
    public abstract void updateEntityFromDto(ParentDTO dto, @MappingTarget Parent entity);

    @Named("etudiantsToIds")
    protected List<Long> enfantsToIds(List<Etudiant> enfants) {
        if (enfants == null) return null;
        return enfants.stream().map(Etudiant::getId).collect(Collectors.toList());
    }

    @Named("idsToEtudiants")
    protected List<Etudiant> idsToEnfants(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> etudiantRepository.findById(id).orElse(null))
                .filter(etudiant -> etudiant != null)
                .collect(Collectors.toList());
    }
}
