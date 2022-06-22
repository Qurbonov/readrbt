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
class SPLIT {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("MONTH")
	private int MONTH;
	@JsonProperty("TOVARAMOUNT")
	private int TOVARAMOUNT;
}