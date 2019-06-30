package pl.sda.eprzychodnia.infrastructure.dto;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DoctorDto {
    private Long id;
    private String name;
    private String surname;
    private String specialization;
}
