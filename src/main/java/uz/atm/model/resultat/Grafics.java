package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Grafics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("FINYEAR")
    private int finyear;

    @JsonProperty("MONTH")
    private int month;

    @JsonProperty("KLS")
    private String kls;

    @JsonProperty("TOVARSUMMA")
    private Long tovarsumma;

    @JsonProperty("EXPENSE")
    private int expense;

    @JsonProperty("AVANS")
    private Long avans;

}