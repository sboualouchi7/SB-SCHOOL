package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.NiveauDTO;
import ma.salman.sbschool.Models.Niveau;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface NiveauMapper {
    NiveauDTO toDto(Niveau niveau);

    @Mapping(target = "classes", ignore = true)
    Niveau toEntity(NiveauDTO niveauDTO);

    List<NiveauDTO> toDtoList(List<Niveau> niveaux);

    @Mapping(target = "classes", ignore = true)
    void updateEntityFromDto(NiveauDTO dto, @MappingTarget Niveau entity);
}
