package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonIgnoreProperties
public class ResultatMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "etp_id")
    @JsonProperty("ETP_ID")
    private int etp_id;
    @JsonProperty("REQUEST_ID")
    private int request_id;

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @Embedded
    @JsonProperty("PAYLOAD")
    private Payload payload;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class Payload {
        @JsonProperty("LOTID")
        private Long lotId;
        @JsonProperty("PROC_ID")
        private int procId;
        @JsonProperty("LOTDATE1")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date lotDate1;
        @JsonProperty("LOTDATE2")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date lotDate2;
        @JsonProperty("CONTRACTNUM")
        private String contractNum;
        @JsonProperty("CONTRACTDAT")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractDat;
        @JsonProperty("DVR")
        private int dvr;
        @JsonProperty("ORGAN")
        private String organ;
        @JsonProperty("INN")
        private int inn;
        @JsonProperty("LS")
        private String ls;
        @JsonProperty("VENDORNAME")
        private String vendorName;
        @JsonProperty("VENDORBANK")
        private int vendorBank;
        @JsonProperty("VENDORACC")
        private String vendorAcc;
        @JsonProperty("VENDORINN")
        private int vendorInn;
        @JsonProperty("MALOY")
        private String maloy;
        @Column(name = "p_summa")
        @JsonProperty("SUMMA")
        private Long summa;
        @JsonProperty("SUMNDS")
        private Long sumNds;
        @JsonProperty("SROK")
        private int spok;
        @Column(name = "p_avans")
        @JsonProperty("AVANS")
        private String avans;
        @JsonProperty("AVANSDAY")
        private int avansDay;
        @JsonProperty("CONTRACTBEG")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractBeg;
        @JsonProperty("CONTRACTEND")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractEnd;
        @JsonProperty("PURPOSE")
        @Column(columnDefinition = "TEXT")
        private String purpose;
        @JsonProperty("VENDORTERR")
        private int vendorTerr;
        @JsonProperty("BENEFICIAR")
        private String beneficiar;
        @JsonProperty("RASCHOT")
        private int raschot;
        @JsonProperty("REESTR_ID")
        private Long reestrId;
        @JsonProperty("PNFL")
        private Long pnfl;
        @JsonProperty("VENDORCOUNTRY")
        private String vendorCountry;
        @JsonProperty("VENDORFORIEGIN")
        private String vendorForeign;
        @JsonProperty("VENDORINFO")
        private String vendorInfo;
        @JsonProperty("VENDORKLS")
        private String vendorKls;
        @JsonProperty("GEN_ID")
        private int genId;
        @JsonProperty("CONTRACT_ID")
        private int contractId;
        @JsonProperty("VERSION")
        private int version;
        //    @Embedded
        @JsonProperty("FINSRC")
        @OneToMany(cascade = CascadeType.ALL)
        private List<FinSrc> finsrc;
        //    @Embedded
        @OneToMany(cascade = CascadeType.ALL)
        @JsonProperty("SPECIFICATIONS")
        private List<Specifications> specifications;
        //    @Embedded
        @JsonProperty("GRAFICS")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Grafics> grafics;

        @JsonProperty("LINKS")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Links> links;

    }
}
