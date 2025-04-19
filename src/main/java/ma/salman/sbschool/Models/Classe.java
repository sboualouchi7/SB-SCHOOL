package ma.salman.sbschool.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity @Data @NoArgsConstructor
@AllArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "classe_module", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "classe_id"), // Colonne pour cette entité (Classe)
            inverseJoinColumns = @JoinColumn(name = "module_id") // Colonne pour l'autre entité (Module)
    )
    private List<Module> modules = new ArrayList<>();

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;




}
