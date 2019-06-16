package pl.sda.eprzychodnia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class EPrzychodniaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EPrzychodniaApplication.class, args);
    }

}
