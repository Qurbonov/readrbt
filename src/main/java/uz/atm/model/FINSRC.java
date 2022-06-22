package uz.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
class FINSRC {
	@Column(name = "f_npos")
	private int NPOS;
	@Column(name = "f_kls")
	private String KLS;
	private int BANKCODE;
	private String BANKACC;
	@Column(name = "f_summa")
	private int SUMMA;
	@Column(name = "f_avans")
	private String AVANS;
}
