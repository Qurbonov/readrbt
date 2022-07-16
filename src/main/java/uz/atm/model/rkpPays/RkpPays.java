package uz.atm.model.rkpPays;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.DateEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RkpPays extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @JsonProperty("ETP_ID")
    private int etpId;

    @JsonProperty("REQUEST_ID")
    private int requestId;

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @Embedded
    @JsonProperty("PAYLOAD")
    private RkpPaysPayload payload;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class RkpPaysPayload {

        @JsonProperty("PAYID")
        private Integer payId;

        @JsonProperty("PAYTYPE")
        private int payType;

        @JsonProperty("DOCNUMB")
        private String docNumb;

        @JsonProperty("DOCDATE")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date docDate;

        @JsonProperty("SUMPAY")
        private Long sumPay;

        @JsonProperty("CURRENCY")
        private Long currency;

        @JsonProperty("CONTRACT")
        private Long contract;

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("ACCETP")
        private String accetp;

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

        @JsonProperty("VENDORPINFL")
        private String vendorpinfl;

        @JsonProperty("PURPOSE")
        @Column(columnDefinition = "TEXT")
        private String purpose;

        @JsonProperty("CNTRSUM")
        private String cntrsum;
    }
}
