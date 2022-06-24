package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NOTE {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("MARKA")
	private String MARKA;
	@JsonProperty("TECHSPEC")
	private String TECHSPEC;
	@JsonProperty("MANUFACTURER")
	private String MANUFACTURER;
	@JsonProperty("COUNTRY")
	private String COUNTRY;
	@JsonProperty("GARANT")
	private Date GARANT;
	@JsonProperty("GODIZG")
	private Date GODIZG;
	@JsonProperty("SROKGOD")
	private Date SROKGOD;
	@JsonProperty("LICENSE")
	private String LICENSE;
}