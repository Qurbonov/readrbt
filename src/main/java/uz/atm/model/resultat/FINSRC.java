package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
//@Embeddable
@Entity
@NoArgsConstructor
class FINSRC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "f_npos")
	@JsonProperty("NPOS")
	private int NPOS;
	@Column(name = "f_kls")
	@JsonProperty("KLS")
	private String KLS;
	@JsonProperty("BANKCODE")
	private int BANKCODE;
	@JsonProperty("BANKACC")
	private String BANKACC;
	@Column(name = "f_summa")
	@JsonProperty("SUMMA")
	private Long SUMMA;
	@Column(name = "f_avans")
	@JsonProperty("AVANS")
	private String AVANS;
}
