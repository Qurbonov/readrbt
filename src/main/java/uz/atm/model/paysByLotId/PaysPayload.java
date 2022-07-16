package uz.atm.model.paysByLotId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pays_payload")
public class PaysPayload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("DOCNUMB")
    private String docNumb;

    @JsonProperty("DOCDATE")
    private String docDate;

    @JsonProperty("SUMPAY")
    private Long sumPay;

    @JsonProperty("CONTRACT")
    private Long contract;

    @JsonProperty("LOTID")
    private Long lotId;

    @JsonProperty("STATE")
    private int state;

    @JsonProperty("ERRMSG")
    private String errMsg;

}