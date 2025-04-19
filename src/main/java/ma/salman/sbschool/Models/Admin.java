package ma.salman.sbschool.Models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
@EqualsAndHashCode(callSuper = true) //impoter equals() et hashcode()

public class Admin extends Utilisateur{

}
