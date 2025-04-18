package ma.salman.sbschool.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ParentDTO extends UtilisateurDTO{
    private Date dateInscription;
    private String filiere;
    private Long classeId;
    private Long parentId;
    private List<Long> enfantIds;
}
