package pl.sda.eprzychodnia.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto;
import pl.sda.eprzychodnia.infrastructure.entity.Doctor;
import pl.sda.eprzychodnia.infrastructure.repository.DoctorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorFinder {

    private final DoctorRepository doctorRepository;

    public List<DoctorDto> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization)
                .stream()
                .map(Doctor::toDto)
                .collect(Collectors.toList());
    }
}
