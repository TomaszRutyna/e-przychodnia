package pl.sda.eprzychodnia.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "patients.service")
public class PatientsServiceConfig {
    private String url;

}
