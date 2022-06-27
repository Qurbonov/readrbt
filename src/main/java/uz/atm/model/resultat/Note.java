package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("MARKA")
	private String marka;
	@JsonProperty("TECHSPEC")
	private String techSpec;
	@JsonProperty("MANUFACTURER")
	private String manufacturer;
	@JsonProperty("COUNTRY")
	private String country;
	@JsonProperty("GARANT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
	private Date garant;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
	@JsonProperty("GODIZG")
	private Date godIzg;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
	@JsonProperty("SROKGOD")
	private Date spokGod;
	@JsonProperty("LICENSE")
	private String license;
}