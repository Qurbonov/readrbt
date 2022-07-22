package uz.atm.model.responseClaimInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.model.Auditable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ResponseClaimInfo extends Auditable {

    @JsonProperty("RESPONSE_ID")
    private int responseId;
    @JsonProperty("REQUEST_ID")
    private int requestId;
    @JsonProperty("METHOD_NAME")
    private String methodName;

    @JsonProperty("PAYLOAD")
    @Embedded
    private PAYLOAD payload;

    @Embeddable
    @Getter
    @Setter
    private static class PAYLOAD{
        @JsonProperty("LOTID")
        private long lotId;
        @JsonProperty("CLAIM_ID")
        private int claimId;
        @JsonProperty("ORGAN")
        private String organ;
        @JsonProperty("INN")
        private String inn;
        @JsonProperty("KLS")
        private String kls;
        @JsonProperty("SUMMA")
        private long summa;
        @JsonProperty("STATE")
        private int state;
        @JsonProperty("MSG")
        private String msg;
    }
}
