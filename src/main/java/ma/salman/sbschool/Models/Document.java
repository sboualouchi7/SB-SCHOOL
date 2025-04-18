package ma.salman.sbschool.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.StatusDocument;
import ma.salman.sbschool.enums.TypeDocument;

import java.util.Date;

@Entity @Data @NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;


    private Date dateCreation;

    private String fichierUrl;

    @Enumerated(EnumType.STRING)
    private StatusDocument status;

    @Enumerated(EnumType.STRING)
    private TypeDocument type;
}
