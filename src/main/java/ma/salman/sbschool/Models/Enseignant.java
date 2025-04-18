package ma.salman.sbschool.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Entity
@AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("ENSEIGNANT")
@EqualsAndHashCode(callSuper = true)

public class Enseignant extends Utilisateur{

    private String numeroCarte;

    @OneToMany(mappedBy = "enseignant")
    private List<Evaluation> evaluations;

    @ManyToMany
    @JoinTable(
            name = "enseignant_module",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<Module> modules;

}
