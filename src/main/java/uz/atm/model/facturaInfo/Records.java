package uz.atm.model.facturaInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.model.resultat.SPECIFICATIONS;

import javax.persistence.*;
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
    private Long numbInvoice;

    @JsonProperty("DATEINVOICE")
    private String dateInvoice;

    @JsonProperty("CONAME")
    private String coName;

    @JsonProperty("COINN")
    private String coINN;

    @JsonProperty("DATEDOC")
    private String dateDoc;

    @JsonProperty("SUMPAY")
    private Long sumPay;

    @JsonProperty("NAMEWARRANT")
    private String nameWarrant;

    @JsonProperty("STATE")
    private Integer state;

    @JsonProperty("GEN_ID")
    private Long genId;

    @JsonProperty("SPECIFICATIONS")
    @OneToMany
    private List<SPECIFICATIONS> specifications;


}
