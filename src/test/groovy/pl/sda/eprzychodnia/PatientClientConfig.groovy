package pl.sda.eprzychodnia

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.web.client.RestTemplate
import pl.sda.eprzychodnia.config.PatientsServiceConfig
import pl.sda.eprzychodnia.infrastructure.client.patients.PatientClient

class PatientClientConfig {
    @Bean
    @Primary
    PatientClient patientClientMock(RestTemplate restTemplate,
                                    PatientsServiceConfig config) {
        return new PatientClientMock(restTemplate, config)
    }

}
