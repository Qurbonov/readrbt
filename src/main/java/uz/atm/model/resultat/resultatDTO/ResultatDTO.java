package uz.atm.model.resultat.resultatDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultatDTO {

        @JsonProperty("ETP_ID")
        private int etp_id;

        @JsonProperty("REQUEST_ID")
        private int request_id;

        @JsonProperty("METHOD_NAME")
        private String methodName;

        @JsonProperty("PAYLOAD")
        public PayloadDTO payloadDTO;

}
