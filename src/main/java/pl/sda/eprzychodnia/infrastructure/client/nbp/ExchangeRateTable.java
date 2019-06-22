package pl.sda.eprzychodnia.infrastructure.client.nbp;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "tabela_kursow")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRateTable {
    @XmlAttribute(name = "typ")
    private String type;
    @XmlAttribute(name = "uid")
    private String uid;
    @XmlElement(name = "numer_tabeli")
    private String tableNumber;
    @XmlElement(name = "data_publikacji")
    private String publicationDate;

    @XmlElement(name = "pozycja")
    private List<ExchangeRatePosition> positions;

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ExchangeRatePosition {
        @XmlElement(name = "nazwa_waluty")
        private String currencyName;
        @XmlElement(name = "przelicznik")
        private String rate;
        @XmlElement(name = "kod_waluty")
        private String code;
        @XmlElement(name = "kurs_sredni")
        private Double avgExchangeRate;
    }
}
