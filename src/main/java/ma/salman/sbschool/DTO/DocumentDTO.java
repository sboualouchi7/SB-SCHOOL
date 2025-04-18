package ma.salman.sbschool.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.salman.sbschool.enums.StatusDocument;
import ma.salman.sbschool.enums.TypeDocument;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {
    private Long id;
    private Long etudiantId;
    private Date dateCreation;
    private String fichierUrl;
    private StatusDocument status;
    private TypeDocument type;
}
