package ma.salman.sbschool.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.TypeEvaluation;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {
    private Long id;
    private Long etudiantId;
    private Long moduleId;
    private Long enseignantId;
    private TypeEvaluation type;
    private float note;
    private Date dateEvaluation;
}
