package pl.sda.eprzychodnia.infrastructure.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.eprzychodnia.domain.DoctorFinder;
import pl.sda.eprzychodnia.infrastructure.dto.DoctorDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/doctors")
public class DoctorsEndpoint {

    private final DoctorFinder doctorFinder;

    @GetMapping("/{specialization}")
    public List<DoctorDto> getBySpecialization(@PathVariable String specialization) {
        return doctorFinder.findBySpecialization(specialization);
    }
}
