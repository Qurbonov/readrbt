package uz.atm.model.rkpEnd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RkpEnd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("RESPONSE_ID")
    private Long responseId;

    @JsonProperty("REQUEST_ID")
    private Long requestId;

    @JsonProperty("PAYLOAD")
    @Embedded
    private RkpEndPayload payload;

    @Embeddable
    @Data
    static class RkpEndPayload {

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("GEN_ID")
        private Long genId;

        @JsonProperty("ID")
        private Long rkpEndId;

        @JsonProperty("ACTION")
        private Integer action;

        @JsonProperty("STRAF")
        private String straf;

        @JsonProperty("SITE")
        private String site;

        @JsonProperty("MSG")
        private String msg;
    }


}
