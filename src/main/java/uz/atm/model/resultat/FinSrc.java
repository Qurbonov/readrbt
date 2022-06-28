package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class FinSrc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "f_npos")
	@JsonProperty("NPOS")
	private int npos;
	@Column(name = "f_kls")
	@JsonProperty("KLS")
	private String kls;
	@JsonProperty("BANKCODE")
	private int bankCode;
	@JsonProperty("BANKACC")
	private String bankAcc;
	@Column(name = "f_summa")
	@JsonProperty("SUMMA")
	private Long summa;
	@Column(name = "f_avans")
	@JsonProperty("AVANS")
	private String avans;
}
