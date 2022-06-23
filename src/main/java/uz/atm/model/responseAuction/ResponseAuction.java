package uz.atm.model.responseAuction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ResponseAuction {
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

        @JsonProperty("STATE")
        private int state;

        @JsonProperty("MSG")
        private String msg;
    }

}
