package ma.salman.sbschool.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.NumeroSeance;
import ma.salman.sbschool.enums.StatusSeance;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDTO {
    private Long id;
    private Long moduleId;
    private Date date;
    private NumeroSeance numeroSeance;
    private StatusSeance status;
    private List<Long> etudiantIds;
}
