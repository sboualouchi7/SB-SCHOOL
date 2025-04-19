package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.UtilisateurDTO;
import ma.salman.sbschool.Models.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDTO toDto(Utilisateur utilisateur);
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
    List<UtilisateurDTO> toDtoList(List<Utilisateur> utilisateurs);
    void updateEntityFromDto(UtilisateurDTO dto, @MappingTarget Utilisateur entity);
}
