package ma.salman.sbschool.repository;

import ma.salman.sbschool.Models.Document;
import ma.salman.sbschool.enums.StatusDocument;
import ma.salman.sbschool.enums.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findByEtudiantId(Long etudiantId);
    List<Document> findByType(TypeDocument type);
    List<Document> findByStatus(StatusDocument status);
}
