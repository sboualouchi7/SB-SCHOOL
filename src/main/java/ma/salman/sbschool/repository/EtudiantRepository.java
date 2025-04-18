package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findByClasseId(Long classeId);
    List<Etudiant> findByParentId(Long parentId);
}
