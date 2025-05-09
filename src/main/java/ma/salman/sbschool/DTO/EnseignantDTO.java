package ma.salman.sbschool.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantDTO extends UtilisateurDTO{
    private String numeroCarte;
    private List<Long> moduleIds;
    private List<SeanceDTO> seances;
}
