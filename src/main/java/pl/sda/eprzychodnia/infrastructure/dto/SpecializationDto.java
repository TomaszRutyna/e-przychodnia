package pl.sda.eprzychodnia.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.eprzychodnia.infrastructure.type.Specialization;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SpecializationDto {
    private Specialization id;
    private String label;
}
