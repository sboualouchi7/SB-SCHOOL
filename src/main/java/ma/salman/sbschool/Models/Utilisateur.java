package ma.salman.sbschool.Models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.Role;
import ma.salman.sbschool.enums.Sexe;

import java.sql.Blob;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE",length = 10, discriminatorType = DiscriminatorType.STRING)
@Data @NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String email;
    private Date dateNaissance;
    private String adresse;
    private String telephone;
    private String password;

    @Lob
    private Byte[] photo;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    private Role role;


}
