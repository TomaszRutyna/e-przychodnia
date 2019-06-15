package pl.sda.eprzychodnia.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto;
import pl.sda.eprzychodnia.infrastructure.entity.Doctor;
import pl.sda.eprzychodnia.infrastructure.repository.DoctorRepository;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public void create(DoctorDto dto) {
        Doctor doctor = Doctor.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .specialization(dto.getSpecialization())
                .build();
        doctorRepository.save(doctor);
    }

    public void delete(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
