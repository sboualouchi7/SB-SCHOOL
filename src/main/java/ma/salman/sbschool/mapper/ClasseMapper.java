package ma.salman.sbschool.mapper;


import ma.salman.sbschool.DTO.ClasseDTO;
import ma.salman.sbschool.Models.Classe;
import ma.salman.sbschool.Models.Niveau;
import ma.salman.sbschool.repository.NiveauRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ClasseMapper {
    @Autowired
    protected NiveauRepository niveauRepository;

    @Mapping(target = "niveauId", source = "niveau.id")
    public abstract ClasseDTO toDto(Classe classe);

    @Mapping(target = "niveau", source = "niveauId", qualifiedByName = "idToNiveau")
    @Mapping(target = "modules", ignore = true)
    @Mapping(target = "etudiants", ignore = true)
    public abstract Classe toEntity(ClasseDTO classeDTO);

    public abstract List<ClasseDTO> toDtoList(List<Classe> classes);

    @Mapping(target = "niveau", source = "niveauId", qualifiedByName = "idToNiveau")
    @Mapping(target = "modules", ignore = true)
    @Mapping(target = "etudiants", ignore = true)
    public abstract void updateEntityFromDto(ClasseDTO dto, @MappingTarget Classe entity);

    @Named("idToNiveau")
    protected Niveau idToNiveau(int id) {

        return niveauRepository.findById(id).orElse(null);
    }
}
