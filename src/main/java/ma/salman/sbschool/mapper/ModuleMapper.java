package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.ModuleDTO;
import ma.salman.sbschool.Models.Classe;
import ma.salman.sbschool.Models.Module;
import ma.salman.sbschool.repository.ClasseRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ModuleMapper {

    @Autowired
    protected ClasseRepository classeRepository;

    @Mapping(target = "classeId", expression = "java(module.getClasse() != null ? module.getClasse().getId() : null)")
    @Mapping(target = "classesIds", expression = "java(mapClassesToIds(module.getClasses()))")
    public abstract ModuleDTO toDto(Module module);

    @Mapping(target = "classe", source = "classeId", qualifiedByName = "idToClasse")
    @Mapping(target = "classes", ignore = true) // Géré manuellement dans le service
    public abstract Module toEntity(ModuleDTO moduleDTO);

    public abstract List<ModuleDTO> toDtoList(List<Module> modules);

    @Mapping(target = "classe", source = "classeId", qualifiedByName = "idToClasse")
    @Mapping(target = "classes", ignore = true)
    public abstract void updateEntityFromDto(ModuleDTO dto, @MappingTarget Module entity);

    @Named("idToClasse")
    protected Classe idToClasse(Long id) {
        if (id == null) return null;
        return classeRepository.findById(id).orElse(null);
    }

    protected List<Long> mapClassesToIds(List<Classe> classes) {
        if (classes == null || classes.isEmpty()) {
            return null;
        }
        return classes.stream()
                .map(Classe::getId)
                .collect(Collectors.toList());
    }
}