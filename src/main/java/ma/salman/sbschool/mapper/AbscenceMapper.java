package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.AbsenceDTO;
import ma.salman.sbschool.Models.Abscence;
import ma.salman.sbschool.Models.Etudiant;
import ma.salman.sbschool.repository.EtudiantRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class AbscenceMapper {

    @Autowired
    protected EtudiantRepository etudiantRepository;

    @Mapping(target = "etudiantId", source = "etudiant.id")
    public abstract AbsenceDTO toDto(Abscence absence);

    @Mapping(target = "etudiant", source = "etudiantId", qualifiedByName = "idToEtudiant")
    @Mapping(target = "justification", ignore = true) // Handle file uploads separately
    public abstract Abscence toEntity(AbsenceDTO absenceDTO);

    public abstract List<AbsenceDTO> toDtoList(List<Abscence> absences);

    @Mapping(target = "etudiant", source = "etudiantId", qualifiedByName = "idToEtudiant")
    @Mapping(target = "justification", ignore = true) // Handle file updates separately
    public abstract void updateEntityFromDto(AbsenceDTO dto, @MappingTarget Abscence entity);

    @Named("idToEtudiant")
    protected Etudiant idToEtudiant(Long id) {
        if (id == null) return null;
        return etudiantRepository.findById(id).orElse(null);
    }
}
