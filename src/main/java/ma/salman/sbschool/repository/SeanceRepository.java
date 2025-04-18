package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Seance;
import ma.salman.sbschool.enums.StatusSeance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByModuleId(Long moduleId);
    List<Seance> findByEtudiantsId(Long etudiantId);
    List<Seance> findByStatus(StatusSeance status);
    List<Seance> findByDate(Date date);
}
