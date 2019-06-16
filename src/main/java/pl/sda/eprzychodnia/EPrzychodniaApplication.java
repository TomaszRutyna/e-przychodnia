package pl.sda.eprzychodnia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySource(value = {"application.properties", "application-ext.properties"},
        ignoreResourceNotFound = true)
public class EPrzychodniaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EPrzychodniaApplication.class, args);
    }

}
