package ma.salman.sbschool.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity @Data @NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PARENT")
@EqualsAndHashCode(callSuper = true)

public class Parent extends Utilisateur{

    @OneToMany(mappedBy = "parent")
    private List<Etudiant> etudiants;
}
