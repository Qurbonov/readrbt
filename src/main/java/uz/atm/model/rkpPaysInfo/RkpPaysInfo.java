package uz.atm.model.rkpPaysInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.successInfo.SuccessInfo;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RkpPaysInfo {
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

        @JsonProperty("ID")
        private long id;

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("OPERDAY")
        private String operDay;

        @JsonProperty("DOCNUMB")
        private String docNumb;

        @JsonProperty("DOCDATE")
        private String docDate;

        @JsonProperty("ACC")
        private String acc;

        @JsonProperty("SUMPAY")
        private double sumPay;

        @JsonProperty("CONTRACT")
        private long contract;

        @JsonProperty("STATE")
        private int state;

        @JsonProperty("ERRMSG")
        private String errMsg;
    }

}
