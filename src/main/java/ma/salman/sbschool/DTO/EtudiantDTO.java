package ma.salman.sbschool.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDTO extends UtilisateurDTO{

    private Date dateInscription;
    private String filiere;
    private Long classeId;
    private Long parentId;
}

