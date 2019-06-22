package pl.sda.eprzychodnia.infrastructure.type;

import lombok.Getter;
import lombok.Setter;

public enum Specialization {
    CARDILOGIST("Kardiologia"),
    OCULIST("Okulista"),
    INTERNIST("Internista");

    @Getter
    @Setter
    String label;

    Specialization(String label) {
        this.label = label;
    }
}
