package uz.atm.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Date;

@Data
@AllArgsConstructor
@Embeddable

public class Payload {
	private Long LOTID;
	private int proc_id;
	private Date LOTDATE1;
	private Date LOTDATE2;
	private String CONTRACTNUM;
	private Date CONTRACTDAT;
	private int DVR;
	private String ORGAN;
	private int INN;
	private String LS;
	private String VENDORNAME;
	private int VENDORBANK;
	private String VENDORACC;
	private int VENDORINN;
	private String MALOY;
	@Column(name = "p_summa")
	private Long SUMMA;
	private Long SUMNDS;
	private int SROK;
	@Column(name = "p_avans")
	private String AVANS;
	private int AVANSDAY;
	private Date CONTRACTBEG;
	private Date CONTRACTEND;
	private String PURPOSE;
	private int VENDORTERR;
	private String BENEFICIAR;
	private int RASCHOT;
	private int reestr_id;
	private int PNFL;
	private String VENDORCOUNTRY;
	private String VENDORFORIEGIN;
	private String VENDORINFO;
	private String VENDORKLS;
	private int gen_id;
	private int contract_id;
	private int version;
	@Embedded
	private FINSRC finsrc;
	@Embedded
	private SPECIFICATIONS specifications;
	@Embedded
	private GRAFICS grafics;
	@Embedded
	private LINKS links;

	public Payload()
	{
	}


}