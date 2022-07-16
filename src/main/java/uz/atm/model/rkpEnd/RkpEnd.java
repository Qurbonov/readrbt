package uz.atm.model.rkpEnd;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.DateEntity;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RkpEnd extends DateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("ETP_ID")
	private Long etpId;

	@JsonProperty("REQUEST_ID")
	private Long requestId;

	@JsonProperty("METHOD_NAME")
	private String methodName;


	@JsonProperty("PAYLOAD")
	@Embedded
	private RkpEndPayload payload;

	@Embeddable
	@Data
	static class RkpEndPayload {

		@JsonProperty("LOTID")
		private Long lotId;

		@JsonProperty("GEN_ID")
		private Long genId;

		@JsonProperty("ID")
		private Long rkpEndId;

		@JsonProperty("ACTION")
		private Integer action;

		@JsonProperty("STRAF")
		private String straf;

		@JsonProperty("SITE")
		private String site;

		@JsonProperty("MSG")
		private String msg;
	}


}
