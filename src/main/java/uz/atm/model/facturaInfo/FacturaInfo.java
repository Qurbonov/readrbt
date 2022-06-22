package uz.atm.model.facturaInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacturaInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("RESPONSE_ID")
    private Long responseId;

    @JsonProperty("REQUEST_ID")
    private Long requestId;

    @JsonProperty("PAYLOAD")
    @Embedded
    private FacturaInfoInfoPayload payload;


    @Data
    @Embeddable
    static class FacturaInfoInfoPayload {

        @JsonProperty("COUNTS")
        private Integer counts;

        @JsonProperty("RECORDS")
        @OneToMany
        private List<Records> records;
    }

}
