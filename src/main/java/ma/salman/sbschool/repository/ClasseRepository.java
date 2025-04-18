package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    List<Classe> findByNiveauId(Long niveauId);

}
