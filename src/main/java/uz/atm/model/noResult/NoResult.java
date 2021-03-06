package uz.atm.model.noResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.Auditable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class NoResult extends Auditable {

	@JsonProperty("ETP_ID")
	private int etpId;

	@JsonProperty("REQUEST_ID")
	private long requestId;

	@JsonProperty("METHOD_NAME")
	private String methodName;

	@JsonProperty("PAYLOAD")
	@Embedded
	private Payload payload;

	@Embeddable
	@Data
	private static class Payload {
		@JsonProperty("LOTID")
		private Long lotId;

		@JsonProperty("PROC_ID")
		private long procId;

		@JsonProperty("PRICH")
		private long prich;
	}
}
