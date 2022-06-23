package uz.atm.model.rkpPaysInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Payload{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("PAYID")
    public int payId;

    @JsonProperty("OPERDAY")
    public String operDay;

    @JsonProperty("PAYTYPE")
    public int payType;

    @JsonProperty("ID")
    public int identity;

    @JsonProperty("DOCNUMB")
    public String docNumb;

    @JsonProperty("DOCDATE")
    public String docDate;

    @JsonProperty("SUMPAY")
    public long sumPay;

    @JsonProperty("CONTRACT")
    public int contract;

    @JsonProperty("LOTID")
    public long lotId;

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
}
