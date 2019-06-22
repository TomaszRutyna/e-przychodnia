package pl.sda.eprzychodnia.infrastructure.client.patients;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.sda.eprzychodnia.config.PatientsServiceConfig;
import pl.sda.eprzychodnia.infrastructure.client.patients.dto.PatientDto;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PatientClient {

    private final RestTemplate restTemplate;
    private final PatientsServiceConfig config;

    public void create(PatientDto dto) {
        HttpEntity<PatientDto> rq = new HttpEntity<>(dto, new HttpHeaders());
        restTemplate.exchange(config.getUrl(), HttpMethod.POST, rq, Void.class);
    }

    public void update(PatientDto dto) {
        HttpEntity<PatientDto> rq = new HttpEntity<>(dto, new HttpHeaders());
        restTemplate.exchange(config.getUrl(), HttpMethod.PUT, rq, Void.class);
    }

    public List<PatientDto> getAll() {
        return restTemplate.getForEntity(config.getUrl(), List.class).getBody();
    }

    public Optional<PatientDto> get(Long id) {
        try {
            return Optional.ofNullable(restTemplate.getForEntity(config.getUrl() + "/" + id, PatientDto.class).getBody());
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    public void delete(Long id) {
        restTemplate.delete(config.getUrl() + "/" + id);
    }
}
