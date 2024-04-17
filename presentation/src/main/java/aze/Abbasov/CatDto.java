package aze.Abbasov;

import aze.Abbasov.models.CatColor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class CatDto {
    private String name;
    private LocalDate birthDate;
    private String breed;
    private CatColor color;
    private Long owner;
    private List<Long> friends;
    public CatDto() {
    }
}
