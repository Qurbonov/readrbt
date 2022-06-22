package uz.atm.model.requestEtp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.sh.jsonparsetest.entity.resultat.SPECIFICATIONS;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestEtp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("RESPONSE_ID")
    private Long responseId;

    @JsonProperty("REQUEST_ID")
    private Long requestId;

    @JsonProperty("PAYLOAD")
    @Embedded
    private RequestEtpPayload payload;


    @Embeddable
    @Data
    static class RequestEtpPayload {

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("DOCDATE")
        private String docDate;

        @JsonProperty("ORGAN")
        private String organ;

        @JsonProperty("ACC")
        private String acc;

        @JsonProperty("SUMLOT")
        private Long sumlot;

        @JsonProperty("PLTF")
        private Integer pltf;

        @JsonProperty("MONTH")
        private Integer month;

        @JsonProperty("SPECIFICATIONS")
        @OneToMany
        private List<SPECIFICATIONS> specifications;
    }


}