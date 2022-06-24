package uz.atm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class General {

	@JsonProperty("METHOD_NAME")
	private String METHOD_NAME;

	@JsonProperty("ETP_ID")
	private String ETP_ID;

}
