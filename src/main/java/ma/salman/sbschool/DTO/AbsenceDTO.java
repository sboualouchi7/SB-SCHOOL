package ma.salman.sbschool.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.NumeroSeance;
import ma.salman.sbschool.enums.TypeAbscence;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AbsenceDTO {
    private Long id;
    private Long etudiantId;
    private Date date;
    private String motif;

    private NumeroSeance numeroSeance;
    private TypeAbscence type;
}
