package ma.salman.sbschool.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.TypeModule;

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

    @ManyToMany(mappedBy = "modules")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "classe")
    private List<Module> modules;



}
