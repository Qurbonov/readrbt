package uz.atm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class General {

    @JsonProperty("ETP_ID")
    private Long ETP_ID;

    @JsonProperty("REQUEST_ID")
    private Long REQUEST_ID;

    @JsonProperty("METHOD_NAME")
    private String METHOD_NAME;
}
