package uz.atm.model.paysByLotId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.responseAuction.ResponseAuction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaysByLotId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @JsonProperty("RESPONSE_ID")
    private long responseId;

    @JsonProperty("REQUEST_ID")
    private long requestId;

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @JsonProperty("PAYLOAD")
    @Embedded
    private Payload payload;
    @Embeddable
    @Data
    private static class Payload{
        @JsonProperty("PAYID")
        private long payId;

        @JsonProperty("OPERDAY")
        private String operDay;

        @JsonProperty("PAYTYPE")
        private int payType;

        @JsonProperty("ID")
        private long id;


        @JsonProperty("DOCNUMB")
        private String docNumb;

        @JsonProperty("DOCDATE")
        private String docDate;

        @JsonProperty("SUMPAY")
        private long sumPay;

        @JsonProperty("CONTRACT")
        private long contract;

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("STATE")
        private int state;

        @JsonProperty("ERRMSG")
        private String errMsg;
    }
}
