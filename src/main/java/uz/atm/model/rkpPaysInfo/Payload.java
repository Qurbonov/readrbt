package uz.atm.model.rkpPaysInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
class Payload {
	@JsonProperty("PAYID")
	public int payId;
	@JsonProperty("OPERDAY")
	@JsonFormat(pattern = "ddMMyyyy")
	public LocalDate operDay;
	@JsonProperty("PAYTYPE")
	public int payType;
	@JsonProperty("ID")
	public int identity;
	@JsonProperty("DOCNUMB")
	public String docNumb;
	@JsonProperty("DOCDATE")
	@JsonFormat(pattern = "ddMMyyyy")
	public LocalDate docDate;
	@JsonProperty("SUMPAY")
	public long sumPay;
	@JsonProperty("CONTRACT")
	public Integer contract;
	@JsonProperty("LOTID")
	public Long lotId;
	@JsonProperty("CLNAME")
	public String clName;
	@JsonProperty("CLMFO")
	public String clmfo;
	@JsonProperty("CLACC")
	public String clacc;
	@JsonProperty("CLKLS")
	public String clkls;
	@JsonProperty("CLINN")
	public String clinn;
	@JsonProperty("CLPINFL")
	public String clpinfl;
	@JsonProperty("CONAME")
	public String coName;
	@JsonProperty("COMFO")
	public String comfo;
	@JsonProperty("COACC")
	public String coAcc;
	@JsonProperty("COKLS")
	public String cokls;
	@JsonProperty("COINN")
	public String coinn;
	@JsonProperty("COPINFL")
	public String copinfl;
	@JsonProperty("OPER")
	public String oper;
	@JsonProperty("PURPOSE")
	public String purpose;
	@JsonProperty("ERRMSG")
	public String errMsg;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}

/*{
  "RESPONSE_ID": 3546114,
  "REQUEST_ID": 2253590,
  "METHOD_NAME": "RKP_PAYS_INFO",
  "PAYLOAD": {
    "PAYID": 326584,
    "ID": 560426239,
    "LOTID": 22111008515365,
    "OPERDAY": "15072022",
    "DOCNUMB": "326584",
    "DOCDATE": "15072022",
    "ACC": "700110860262877950600262007",
    "SUMPAY": 241500000,
    "CONTRACT": 30055641,
    "STATE": 4,
    "ERRMSG": "000 -  "
  }
}*/