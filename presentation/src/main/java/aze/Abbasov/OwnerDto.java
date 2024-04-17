package aze.Abbasov;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class OwnerDto {
    private LocalDate birthDate;
    private List<CatDto> cats;
    private String name;
    public OwnerDto() { }
}
