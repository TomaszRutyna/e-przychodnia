package pl.sda.eprzychodnia.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "second_name")
    private String surname;
    private String specialization;

    @OneToMany
    private Set<DoctorAvailability> availabilities;

    public DoctorDto toDto() {
        return DoctorDto.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .specialization(specialization)
                .build();
    }
}
