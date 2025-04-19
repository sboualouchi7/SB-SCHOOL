package ma.salman.sbschool.mapper;

import ma.salman.sbschool.DTO.DocumentDTO;
import ma.salman.sbschool.Models.Document;
import ma.salman.sbschool.Models.Etudiant;
import ma.salman.sbschool.repository.EtudiantRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper {
    @Autowired
    protected EtudiantRepository etudiantRepository;

    @Mapping(target = "etudiantId", source = "etudiant.id")
    public abstract DocumentDTO toDto(Document document);

    @Mapping(target = "etudiant", source = "etudiantId", qualifiedByName = "idToEtudiant")
    public abstract Document toEntity(DocumentDTO documentDTO);

    public abstract List<DocumentDTO> toDtoList(List<Document> documents);

    @Mapping(target = "etudiant", source = "etudiantId", qualifiedByName = "idToEtudiant")
    public abstract void updateEntityFromDto(DocumentDTO dto, @MappingTarget Document entity);

    @Named("idToEtudiant")
    protected Etudiant idToEtudiant(Long id) {
        if (id == null) return null;
        return etudiantRepository.findById(id).orElse(null);
    }
}
