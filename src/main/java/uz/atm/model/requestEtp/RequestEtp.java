package uz.atm.model.requestEtp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;
import uz.atm.model.Auditable;
import uz.atm.model.resultat.Specifications;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class RequestEtp extends Auditable {

    @JsonProperty("ETP_ID")
    private Long etpId;

    @JsonProperty("REQUEST_ID")
    private Long requestId;

    @JsonProperty("METHOD_NAME")
    private String methodName;

    @JsonProperty("PAYLOAD")
    @Embedded
    private RequestEtpPayload payload;


    @Embeddable
    @Data
    public static class RequestEtpPayload {

        @JsonProperty("LOTID")
        private Long lotId;

        @JsonProperty("DOCDATE")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
        private Date docDate;

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
        @OneToMany(cascade = CascadeType.ALL)
        private List<Specifications> specifications;
    }


}