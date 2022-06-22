package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@JsonIgnoreProperties
public class ResultatMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private Long id;

	@Column(name = "etp_id")
	@JsonProperty("ETP_ID")
	private int etp_id;

	@JsonProperty("REQUEST_ID")
	private int request_id;

	@JsonProperty("METHOD_NAME")
	private String methodName;

	@Embedded
	@JsonProperty("PAYLOAD")
	private Payload payload;

}
