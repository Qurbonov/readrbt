package uz.atm.model.manuals;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ManualIdentifier {
    @JsonProperty("DIGEST_ID")
    private Long DIGEST_ID;

    @JsonProperty("TYPE")
    private String TYPE;


}
