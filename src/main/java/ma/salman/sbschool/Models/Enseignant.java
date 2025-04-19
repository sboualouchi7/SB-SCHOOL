package ma.salman.sbschool.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("ENSEIGNANT")
@EqualsAndHashCode(callSuper = true)

public class Enseignant extends Utilisateur{

    private String numeroCarte;

    @OneToMany(mappedBy = "enseignant")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "enseignant") // Un enseignant a plusieurs modules
    private List<Module> modules = new ArrayList<>();

    @OneToMany(mappedBy = "enseignant")  // Un enseignant a plusieurs séances
    private List<Seance> seances = new ArrayList<>();

}
