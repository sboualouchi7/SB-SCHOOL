package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Abscence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Abscence,Long> {
    List<Abscence> findByEtudiantId(Long etudiantId);
    List<Abscence> findByDate(Date date);
}
