package uz.atm.model.errorInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("REQUEST_ID")
    private Long requestId;

    @JsonProperty("RESPONSE_ID_PARENT")
    private Long responseIdParent;

    @JsonProperty("REQUEST_ID_PARENT")
    private Long requestIdParent;

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @JsonProperty("PAYLOAD")
    @Embedded
    private ErrorPayload payload;

    @Data
    @Embeddable
    static class ErrorPayload {

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("ERRTXT")
        private String errTxt;

    }
}
