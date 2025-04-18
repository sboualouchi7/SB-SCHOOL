package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

    List<Evaluation> findByEtudiantId(Long etudiantId);
    List<Evaluation> findByModuleId(Long moduleId);
    List<Evaluation> findByEnseignantId(Long enseignantId);
}
