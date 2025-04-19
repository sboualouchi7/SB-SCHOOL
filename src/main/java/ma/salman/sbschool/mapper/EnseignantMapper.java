package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.EnseignantDTO;
import ma.salman.sbschool.DTO.SeanceDTO;
import ma.salman.sbschool.Models.Enseignant;
import ma.salman.sbschool.Models.Module;
import ma.salman.sbschool.Models.Seance;
import ma.salman.sbschool.repository.ModuleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {SeanceMapper.class})
public abstract class EnseignantMapper {
    @Autowired
    protected ModuleRepository moduleRepository;

    @Mapping(target = "moduleIds", source = "modules", qualifiedByName = "modulesToIds")
    @Mapping(target = "seances", source = "seances", qualifiedByName = "seancesToDtos")
    public abstract EnseignantDTO toDto(Enseignant enseignant);

    @Mapping(target = "modules", source = "moduleIds", qualifiedByName = "idsToModules")
    @Mapping(target = "seances", ignore = true) // On ignore car c'est géré côté Seance
    public abstract Enseignant toEntity(EnseignantDTO enseignantDTO);

    public abstract List<EnseignantDTO> toDtoList(List<Enseignant> enseignants);

    @Mapping(target = "modules", source = "moduleIds", qualifiedByName = "idsToModules")
    @Mapping(target = "seances", ignore = true) // On ignore lors de la mise à jour
    public abstract void updateEntityFromDto(EnseignantDTO dto, @MappingTarget Enseignant entity);

    @Named("modulesToIds")
    protected List<Long> modulesToIds(List<Module> modules) {
        if (modules == null) return null;
        return modules.stream().map(Module::getId).collect(Collectors.toList());
    }

    @Named("idsToModules")
    protected List<Module> idsToModules(List<Long> ids) {
        if (ids == null) return null;
        return ids.stream().map(id -> moduleRepository.findById(id).orElse(null))
                .filter(module -> module != null)
                .collect(Collectors.toList());
    }

    @Named("seancesToDtos")
    protected List<SeanceDTO> seancesToDtos(List<Seance> seances) {
        if (seances == null) return null;
        return seances.stream()
                .map(seance -> {
                    SeanceDTO dto = new SeanceDTO();
                    dto.setId(seance.getId());
                    // On ne met pas l'enseignant ici pour éviter la récursion infinie
                    return dto;
                })
                .collect(Collectors.toList());
    }
}