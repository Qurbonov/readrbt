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
@AllArgsConstructor
@NoArgsConstructor
@Entity
class LINKS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("FILENAME")
	private String FILENAME;
	@JsonProperty("LINKDOC")
	private String linkdoc;
}