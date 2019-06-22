package pl.sda.eprzychodnia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.eprzychodnia.infrastructure.client.nbp.ExchangeRateClient;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExchangeRateClientTest {

    @Autowired
    private ExchangeRateClient client;

    @Test
    public void shouldGetData() {
        //when
       //client.getExchangeRate(LocalDate.now());
    }
}
