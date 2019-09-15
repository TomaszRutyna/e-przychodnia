package pl.sda.eprzychodnia.infrastructure.dto;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VisitDto {
    private Long id;
    private String name;
    private String surname;
    private String specialization;
    private Long doctor;
}
