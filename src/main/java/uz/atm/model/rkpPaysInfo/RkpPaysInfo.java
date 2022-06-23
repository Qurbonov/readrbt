package uz.atm.model.rkpPaysInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.successInfo.SuccessInfo;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RkpPaysInfo {
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
    @OneToMany(cascade = CascadeType.ALL)
    private List<Payload> payload;

}
