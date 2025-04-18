package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Integer> {
}
