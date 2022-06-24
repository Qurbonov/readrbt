package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Embeddable

public class Payload {
	@JsonProperty("LOTID")
	private Long LOTID;
	@JsonProperty("PROC_ID")
	private int proc_id;
	@JsonProperty("LOTDATE1")
	private Date LOTDATE1;
	@JsonProperty("LOTDATE2")
	private Date LOTDATE2;
	@JsonProperty("CONTRACTNUM")
	private String CONTRACTNUM;
	@JsonProperty("CONTRACTDAT")
	private Date CONTRACTDAT;
	@JsonProperty("DVR")
	private int DVR;
	@JsonProperty("ORGAN")
	private String ORGAN;
	@JsonProperty("INN")
	private int INN;
	@JsonProperty("LS")
	private String LS;
	@JsonProperty("VENDORNAME")
	private String VENDORNAME;
	@JsonProperty("VENDORBANK")
	private int VENDORBANK;
	@JsonProperty("VENDORACC")
	private String VENDORACC;
	@JsonProperty("VENDORINN")
	private int VENDORINN;
	@JsonProperty("MALOY")
	private String MALOY;
	@Column(name = "p_summa")
	@JsonProperty("SUMMA")
	private Long SUMMA;
	@JsonProperty("SUMNDS")
	private Long SUMNDS;
	@JsonProperty("SROK")
	private int SROK;
	@Column(name = "p_avans")
	@JsonProperty("AVANS")
	private String AVANS;
	@JsonProperty("AVANSDAY")
	private int AVANSDAY;
	@JsonProperty("CONTRACTBEG")
	private Date CONTRACTBEG;
	@JsonProperty("CONTRACTEND")
	private Date CONTRACTEND;
	@JsonProperty("PURPOSE")
	@Column(columnDefinition = "TEXT")
	private String PURPOSE;
	@JsonProperty("VENDORTERR")
	private int VENDORTERR;
	@JsonProperty("BENEFICIAR")
	private String BENEFICIAR;
	@JsonProperty("RASCHOT")
	private int RASCHOT;
	@JsonProperty("REESTR_ID")
	private Long reestr_id;
	@JsonProperty("PNFL")
	private Long PNFL;
	@JsonProperty("VENDORCOUNTRY")
	private String VENDORCOUNTRY;
	@JsonProperty("VENDORFORIEGIN")
	private String VENDORFORIEGIN;
	@JsonProperty("VENDORINFO")
	private String VENDORINFO;
	@JsonProperty("VENDORKLS")
	private String VENDORKLS;
	@JsonProperty("GEN_ID")
	private int gen_id;
	@JsonProperty("CONTRACT_ID")
	private int contract_id;
	@JsonProperty("VERSION")
	private int version;
	//    @Embedded
	@JsonProperty("FINSRC")
	@OneToMany(cascade = CascadeType.ALL)
	private List<FINSRC> finsrc;
	//    @Embedded
	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty("SPECIFICATIONS")
	private List<SPECIFICATIONS> specifications;
	//    @Embedded
	@JsonProperty("GRAFICS")
	@OneToMany(cascade = CascadeType.ALL)
	private List<GRAFICS> grafics;
	
	@JsonProperty("LINKS")
	@OneToMany(cascade = CascadeType.ALL)
	private List<LINKS> links;

	public Payload()
	{
	}
}