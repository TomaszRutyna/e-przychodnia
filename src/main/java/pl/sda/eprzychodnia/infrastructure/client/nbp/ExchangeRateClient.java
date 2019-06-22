package pl.sda.eprzychodnia.infrastructure.client.nbp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class ExchangeRateClient {
    private final RestTemplate restTemplate;

    public void getExchangeRate(LocalDate forDate) {
        ExchangeRateTable table = restTemplate.getForEntity("https://www.nbp.pl/kursy/xml/a119z190621.xml", ExchangeRateTable.class).getBody();

        System.out.println(table.getTableNumber());
    }

}
