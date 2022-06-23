package uz.atm.model.successInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.responseAuction.ResponseAuction;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SuccessInfo {
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
        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("MSG")
        private String msg;
    }

}
