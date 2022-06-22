package uz.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
class SPECIFICATIONS {
	private int FINYEAR;
	private String KLS;
	private int NPOS;
	private int TOVAR;
	private String TOVARNAME;
	private String TOVARNOTE;
	private String TOVAREDIZM;
	private int TOVARAMOUNT;
	private int TOVARPRICE;
	private int TOVARSUMMA;
	private int EXPENSE;

	@Embedded
	private NOTE note;

	@Embedded
	private SPLIT split;

	@Embedded
	private PROPERTIES properties;
}