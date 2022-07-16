package uz.atm.model.contactInfo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.DateEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractInfo extends DateEntity {
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
	private ContactInfoPayload payload;

	@Data
	@Embeddable
	static class ContactInfoPayload {

		@JsonProperty("LOTID")
		private Long lotId;

		@JsonProperty("REGDAT")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
		private Date regDat;

		@JsonProperty("GENID")
		private Long genId;

		@JsonProperty("ID")
		private Long payId;

		@JsonProperty("CONTRACTNUM")
		private String contractNum;

		@JsonProperty("VERSION")
		private Integer version;

		@JsonProperty("SUMMA")
		private Long summa;

		@JsonProperty("LS")
		private String ls;

		@JsonProperty("MFO")
		private String mfo;

		@JsonProperty("ACC")
		private String acc;

		@JsonProperty("INN")
		private Long inn;

		@JsonProperty("KLS")
		private String kls;

		@JsonProperty("STATE")
		private Integer state;

		@JsonProperty("ERRMSG")
		@Column(columnDefinition = "TEXT")
		private String errmsg;

		@JsonProperty("ACTIONNAME")
		private String actionName;
	}
}
