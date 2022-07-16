package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Embeddable
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("PROP_NUMB")
	private int propNumb;
	@JsonProperty("PROP_NAME")
	private String propName;
	@JsonProperty("VAL_NUMB")
	private int valNumb;
	@JsonProperty("VAL_NAME")
	private String valName;
}