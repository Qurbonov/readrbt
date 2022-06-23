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

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @JsonProperty("PAYLOAD")
    @Embedded
    private FacturaInfoInfoPayload payload;


    @Data
    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    static class FacturaInfoInfoPayload {

        @JsonProperty("COUNTS")
        private Integer counts;

        @JsonProperty("RECORDS")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Records> records;
    }

}
