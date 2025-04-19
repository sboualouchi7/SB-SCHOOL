package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.EnseignantDTO;
import ma.salman.sbschool.DTO.SeanceDTO;
import ma.salman.sbschool.Models.Etudiant;
import ma.salman.sbschool.Models.Module;
import ma.salman.sbschool.Models.Seance;
import ma.salman.sbschool.Models.Enseignant;
import ma.salman.sbschool.repository.EtudiantRepository;
import ma.salman.sbschool.repository.ModuleRepository;
import ma.salman.sbschool.repository.EnseignantRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {EnseignantMapper.class})
public abstract class SeanceMapper {
    @Autowired
    protected ModuleRepository moduleRepository;

    @Autowired
    protected EtudiantRepository etudiantRepository;

    @Autowired
    protected EnseignantRepository enseignantRepository;

    @Mapping(target = "moduleId", source = "module.id")
    @Mapping(target = "enseignantId", source = "enseignant", qualifiedByName = "enseignantToDto")
    public abstract SeanceDTO toDto(Seance seance);

    @Mapping(target = "module", source = "moduleId", qualifiedByName = "idToModule")
    @Mapping(target = "enseignant", source = "enseignantId", qualifiedByName = "dtoToEnseignant")
    public abstract Seance toEntity(SeanceDTO seanceDTO);

    public abstract List<SeanceDTO> toDtoList(List<Seance> seances);

    @Mapping(target = "module", source = "moduleId", qualifiedByName = "idToModule")
    @Mapping(target = "enseignant", source = "enseignantId", qualifiedByName = "dtoToEnseignant")
    public abstract void updateEntityFromDto(SeanceDTO dto, @MappingTarget Seance entity);

    @Named("idToModule")
    protected Module idToModule(Long id) {
        if (id == null) return null;
        return moduleRepository.findById(id).orElse(null);
    }



    @Named("enseignantToDto")
    protected EnseignantDTO enseignantToDto(Enseignant enseignant) {
        if (enseignant == null) return null;
        EnseignantDTO dto = new EnseignantDTO();
        dto.setId(enseignant.getId());
        // On ne met pas les séances ici pour éviter la récursion infinie
        return dto;
    }

    @Named("dtoToEnseignant")
    protected Enseignant dtoToEnseignant(EnseignantDTO dto) {
        if (dto == null || dto.getId() == null) return null;
        return enseignantRepository.findById(dto.getId()).orElse(null);
    }
}