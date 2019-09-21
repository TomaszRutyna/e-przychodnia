package pl.sda.eprzychodnia.infrastructure.client.nbp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/**
 * Klasa sluzaca do pobierania danych o walutach z NBP
 *
 * @author trutyna
 * @since 20-09-2019
 */
@Component
@RequiredArgsConstructor
public class ExchangeRateClient {
    private final RestTemplate restTemplate;

    /**
     * Metoda pobiera kursy walut dla podanej daty
     *
     * @see ExchangeRateTable
     *
     * @param forDate dla podanej daty
     * @throws NullPointerException gdy podana data jest nullem
     * @return Nazwa tabeli z NBP
     */
    public String getExchangeRate(LocalDate forDate) {
        ExchangeRateTable table = restTemplate.getForEntity("https://www.nbp.pl/kursy/xml/a119z190621.xml", ExchangeRateTable.class).getBody();

        System.out.println(table.getTableNumber());

        return table.getTableNumber();
    }

}
