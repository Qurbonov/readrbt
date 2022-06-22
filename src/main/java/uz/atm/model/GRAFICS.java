package uz.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
class GRAFICS {
	@Column(name = "g_finyear")
	private int finyear;
	@Column(name = "g_month")
	private int month;
	@Column(name = "g_kls")
	private String kls;
	@Column(name = "g_tovarsumma")
	private int tovarsumma;
	@Column(name = "g_expense")
	private int expense;
	@Column(name = "g_avans")
	private int avans;
}