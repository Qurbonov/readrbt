package uz.atm.model.paysByLotId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "pays_payload")
public class PaysPayload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("PAYID")
    private int payId;

    @JsonProperty("DOCNUMB")
    private String docNumb;

    @JsonProperty("OPERDAY")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date operDay;

    @JsonProperty("ID")
    private Long pId;

    @JsonProperty("PAYTYPE")
    private int payType;

    @JsonProperty("DOCDATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date docDate;

    @JsonProperty("SUMPAY")
    private Long sumPay;

    @JsonProperty("CONTRACT")
    private Long contract;

    @JsonProperty("LOTID")
    private Long lotId;

    @JsonProperty("STATE")
    private int state;

    @JsonProperty("CLNAME")
    @Column(columnDefinition = "TEXT")
    private String clName;

    @JsonProperty("CLMFO")
    private String clMfo;

    @JsonProperty("CLACC")
    private String clAcc;

    @JsonProperty("CLKLS")
    private String clKls;

    @JsonProperty("CLINN")
    private String clInn;

    @JsonProperty("CLPINFL")
    private String clPinfl;

    @JsonProperty("CONAME")
    private String coName;

    @JsonProperty("COMFO")
    private String coMfo;

    @JsonProperty("COACC")
    private String coAcc;

    @JsonProperty("COKLS")
    private String coKls;

    @JsonProperty("COINN")
    private String coInn;

    @JsonProperty("COPINFL")
    private String coPinfl;

    @JsonProperty("OPER")
    private String oper;

    @JsonProperty("PURPOSE")
    @Column(columnDefinition = "TEXT")
    private String purpose;

    @JsonProperty("ERRMSG")
    @Column(columnDefinition = "TEXT")
    private String errMsg;

}
