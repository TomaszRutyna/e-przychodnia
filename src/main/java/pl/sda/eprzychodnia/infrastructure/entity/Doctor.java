package pl.sda.eprzychodnia.infrastructure.entity;

import javax.persistence.*;
import java.util.Set;

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
}
