package uz.atm.model.resultat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class NOTE {
	private String MARKA;
	private String TECHSPEC;
	private String MANUFACTURER;
	private String COUNTRY;
	private Date GARANT;
	private Date GODIZG;
	private Date SROKGOD;
	private String LICENSE;
}