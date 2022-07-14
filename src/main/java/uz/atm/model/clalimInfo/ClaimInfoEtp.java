package uz.atm.model.clalimInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.resultat.FinSrc;
import uz.atm.model.resultat.Grafics;
import uz.atm.model.resultat.Specifications;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClaimInfoEtp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("ETP_ID")
	private int etpId;

	@JsonProperty("REQUEST_ID")
	private int requestId;

	@JsonProperty("METHOD_NAME")
	private String methodName;

	@Embedded
	@JsonProperty("PAYLOAD")
	private ContractinfoPayload payload;


	@Data
	@Embeddable
	@AllArgsConstructor
	@NoArgsConstructor
	private static class ContractinfoPayload {

		@JsonProperty("LOTID")
		private Long lotId;

		@JsonProperty("PROC_ID")
		private Integer procId;

		@JsonProperty("DATE1")
		private String date1;

		@JsonProperty("DATE2")
		private String date2;

		@JsonProperty("DVR")
		private Integer dvr;

		@JsonProperty("ORGAN")
		private String organ;

		@JsonProperty("INN")
		private Long inn;

		@JsonProperty("SUMMA")
		private Long summa;

		@JsonProperty("SROK")
		private Integer srok;

		@JsonProperty("KLS")
		private String kls;

		@JsonProperty("PURPOSE")
		@Column(columnDefinition = "TEXT")
		private String purpose;

		@JsonProperty("FINSRC")
		@OneToMany(cascade = CascadeType.ALL)
		private List<FinSrc> finSrc;

		@JsonProperty("SPECIFICATIONS")
		@OneToMany(cascade = CascadeType.ALL)
		private List<Specifications> specifications;

		@JsonProperty("GRAFICS")
		@OneToMany(cascade = CascadeType.ALL)
		private List<Grafics> grafics;
	}
}
