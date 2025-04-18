package ma.salman.sbschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.salman.sbschool.Models.Module;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findByClasseId(Long classeId);

}
