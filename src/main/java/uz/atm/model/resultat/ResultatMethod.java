package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.atm.model.Auditable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonIgnoreProperties

public class ResultatMethod extends Auditable {

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

        @Transient
        @JsonProperty("LOTDATES1")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date lotDates1;


        @Transient
        @JsonProperty("LOTDATES2")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date lotDates2;

        public Date getLotDates1() {
            return lotDate1;
        }

        public Date getLotDates2() {
            return lotDate2;
        }

        @JsonProperty("LOTDATE2")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date lotDate2;


        @JsonProperty("CONTRACTNUM")
        private String contractNum;


        @JsonProperty("CONTRACTDAT")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractDat;

        @Transient
        @JsonProperty("CONTRACTDATS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date contractSDat;

        public Date getContractSDat() {
            return contractDat;
        }

        @JsonProperty("DVR")
        private int dvr;
        @JsonProperty("ORGAN")
        private String organ;

        @Transient
        @JsonProperty("ORGAN_NAME")
        private String organName;

        public String getOrganName() {
            return organName;
        }

        public void setOrganName(String organName) {
            this.organName = organName;
        }

        @JsonProperty("INN")
        private String inn;
        @JsonProperty("LS")
        private String ls;
        @JsonProperty("VENDORNAME")
        private String vendorName;
        @JsonProperty("VENDORBANK")
        private int vendorBank;
        @JsonProperty("VENDORACC")
        private String vendorAcc;
        @JsonProperty("VENDORINN")
        private String vendorInn;
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

        @Transient
        @JsonProperty("CONTRACTBEGS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date contractsBeg;

        public Date getContractsBeg() {
            return contractBeg;
        }

        @JsonProperty("CONTRACTEND")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date contractEnd;

        @Transient
        @JsonProperty("CONTRACTENDS")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
        private Date contractsEnd;

        public Date getContractsEnd() {
            return contractEnd;
        }

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
