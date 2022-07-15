package uz.atm.model.rkpPaysInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private Long id;

	@JsonProperty("RESPONSE_ID")
	private Long responseId;

	@JsonProperty("REQUEST_ID")
	private Long requestId;

	@JsonProperty("METHOD_NAME")
	private String methodName;

	@JsonProperty("PAYLOAD")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Payload> payload;

}
