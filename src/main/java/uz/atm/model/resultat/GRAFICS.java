package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
class GRAFICS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "g_finyear")
	@JsonProperty("FINYEAR")
	private int finyear;
	@JsonProperty("MONTH")
	@Column(name = "g_month")
	private int month;
	@JsonProperty("KLS")
	@Column(name = "g_kls")
	private String kls;
	@JsonProperty("TOVARSUMMA")
	@Column(name = "g_tovarsumma")
	private Long tovarsumma;
	@JsonProperty("EXPENSE")
	@Column(name = "g_expense")
	private int expense;
	@JsonProperty("AVANS")
	@Column(name = "g_avans")
	private Long avans;
}