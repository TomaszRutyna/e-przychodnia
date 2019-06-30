package pl.sda.eprzychodnia

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import pl.sda.eprzychodnia.config.PatientsServiceConfig
import pl.sda.eprzychodnia.infrastructure.client.patients.PatientClient
import pl.sda.eprzychodnia.infrastructure.client.patients.dto.PatientDto

class PatientClientMock extends PatientClient {

    PatientClientMock(
            RestTemplate restTemplate,
            PatientsServiceConfig config) {
        super(restTemplate, config)
    }

    @Override
    void create(PatientDto dto) {
        //do nothing
    }

    @Override
    void update(PatientDto dto) {
        //do noting
    }

    @Override
    List<PatientDto> getAll() {
        return [PatientDto.builder()
                        .id(1).firstName("Adam")
                        .lastName("Malysz")
                        .build(),
                PatientDto.builder()
                        .id(2).firstName("Robert")
                        .lastName("Kubica")
                        .build()
        ]
    }

    @Override
    Optional<PatientDto> get(Long id) {
        return Optional.of(PatientDto.builder()
                .id(1).firstName("Adam")
                .lastName("Malysz")
                .build())
    }

    @Override
    void delete(Long id) {
        //do nothing
    }
}