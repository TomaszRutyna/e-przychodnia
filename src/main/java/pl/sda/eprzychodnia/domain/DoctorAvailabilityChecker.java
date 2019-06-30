package pl.sda.eprzychodnia.domain;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.eprzychodnia.infrastructure.repository.DoctorRepository;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorAvailabilityChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorAvailabilityChecker.class);

    private final DoctorRepository doctorRepository;

    @Scheduled(fixedDelay = 5000)
    @Transactional
    public void checkIfDoctorsEnterAvailability() {
        LOGGER.info("Check doctors availability");

        String doctorsWithoutAvailabilities = doctorRepository.findAll()
                .stream()
                .filter(doc -> doc.getAvailabilities() == null
                        || doc.getAvailabilities().isEmpty())
                .map(doc -> doc.getId().toString())
                .collect(Collectors.joining(", "));
        if (!doctorsWithoutAvailabilities.isEmpty()) {
            LOGGER.warn("Some doctors have not got availabilities");
        }
    }
}
