package ma.salman.sbschool.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ETUDIANT")
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends Utilisateur{

        private Date dateInscription ;
        private String filiere;


        @ManyToOne
        @JoinColumn(name = "classe_id")
        private Classe classe;

        @ManyToOne
        @JoinColumn(name = "parent_id")
        private Parent parent;

        @OneToMany(mappedBy = "etudiant")
        private List<Evaluation> evaluations;

        @OneToMany(mappedBy = "etudiant")
        private List<Abscence>  abscences;

        @OneToMany(mappedBy = "etudiant")
        private List<Document> documents;


        @ManyToMany
        @JoinTable(
                name = "etudiant_seance",
                joinColumns = @JoinColumn(name = "etudiant_id"),
                inverseJoinColumns = @JoinColumn(name = "seance_id")
        )
        private List<Seance> seances;
}
