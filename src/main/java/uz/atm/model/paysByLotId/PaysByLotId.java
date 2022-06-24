package uz.atm.model.paysByLotId;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaysByLotId {
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
	private Payload payload;

	@Embeddable
	@Data
	private static class Payload {
		@JsonProperty("PAYID")
		private Long payId;

		@JsonProperty("OPERDAY")
		private String operDay;

		@JsonProperty("PAYTYPE")
		private int payType;

		@JsonProperty("ID")
		private Long payLotId;

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
}
