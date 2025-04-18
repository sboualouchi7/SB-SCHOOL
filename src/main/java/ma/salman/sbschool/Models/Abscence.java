package ma.salman.sbschool.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.NumeroSeance;
import ma.salman.sbschool.enums.TypeAbscence;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Abscence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NumeroSeance sceance;

    @Enumerated(EnumType.STRING)
    private TypeAbscence type;


    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    private Date date;
    private String motif;


    @Lob
    private byte[] justification;
}
