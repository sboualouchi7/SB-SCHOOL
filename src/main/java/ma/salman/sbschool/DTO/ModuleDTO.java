package ma.salman.sbschool.DTO;

import ma.salman.sbschool.enums.TypeModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private Long id;
    private String libelle;
    private int volumeHoraire;
    private int seuil;
    private float coefficient;
    private TypeModule typeModule;
    private Long classeId;
    private List<Long> classesIds;
}
