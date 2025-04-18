package ma.salman.sbschool.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.NumeroSeance;
import ma.salman.sbschool.enums.StatusSeance;

import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor
@AllArgsConstructor
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    private Date date;

    @Enumerated(EnumType.STRING)
    private NumeroSeance numeroSeance;

    @Enumerated(EnumType.STRING)
    private StatusSeance status;

    @ManyToMany(mappedBy = "seances")
    List<Etudiant> etudiants;

}
