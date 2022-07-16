package uz.atm.model.facturaInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.model.resultat.Specifications;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Records {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("INVOICEID")
	private Long invoiceId;

	@JsonProperty("LOTID")
	private Long lotId;

	@JsonProperty("CONTRACT")
	private Long contract;

	@JsonProperty("KLS")
	private String kls;

	@JsonProperty("NUMBINVOICE")
	private String numbInvoice;

	@JsonProperty("DATEINVOICE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
	private Date dateInvoice;

	@JsonProperty("CONAME")
	private String coName;
	@JsonProperty("COINN")
	private String coINN;

	@JsonProperty("DATEDOC")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
	private Date dateDoc;

	@JsonProperty("SUMPAY")
	private Long sumPay;

	@JsonProperty("NAMEWARRANT")
	private String nameWarrant;

	@JsonProperty("STATE")
	private Integer state;

	@JsonProperty("GEN_ID")
	private Long genId;

	@JsonProperty("SPECIFICATIONS")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Specifications> specifications;


}
