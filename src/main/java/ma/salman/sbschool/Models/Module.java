package ma.salman.sbschool.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.TypeModule;

import java.util.ArrayList;
import java.util.List;

@Entity @Data @AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int volumeHoraire;
    private int seuil;
    private float coefficient;

    @Enumerated(EnumType.STRING)
    private TypeModule typeModule;

    @ManyToMany(mappedBy = "modules") // Référence à l'attribut "modules" dans Classe
    private List<Classe> classes = new ArrayList<>();
    //@ManyToMany(mappedBy = "modules")
    //private List<Evaluation> evaluations;



    @ManyToOne // Relation Many-to-One vers Classe
    @JoinColumn(name = "classe_id")
    private Classe classe; // <-- Ajoutez

    @ManyToOne // Un module n'a qu'un seul enseignant
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

}
