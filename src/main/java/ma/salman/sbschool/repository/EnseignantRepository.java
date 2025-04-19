package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    List<Enseignant> findByModulesId(Long moduleId);
}
