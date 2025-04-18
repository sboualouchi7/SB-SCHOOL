package ma.salman.sbschool.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import ma.salman.sbschool.enums.TypeAbscence;

import java.util.Date;

public class AbsenceDTO {
    private Long id;
    private Long etudiantId;
    private Date date;
    private String motif;

    @Enumerated(EnumType.STRING)
    private TypeAbscence type;
}
