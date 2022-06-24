package uz.atm.model.resultat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
//@Embeddable
@Entity
@NoArgsConstructor
public class SPECIFICATIONS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("FINYEAR")
	private int FINYEAR;
	@JsonProperty("KLS")
	private String KLS;
	@JsonProperty("NPOS")
	private int NPOS;
	@JsonProperty("TOVAR")
	private String TOVAR;
	@JsonProperty("TOVARNAME")
	private String TOVARNAME;
	@JsonProperty("TOVARNOTE")
	private String TOVARNOTE;
	@JsonProperty("TOVAREDIZM")
	private String TOVAREDIZM;
	@JsonProperty("TOVARAMOUNT")
	private Long TOVARAMOUNT;
	@JsonProperty("TOVARPRICE")
	private Long TOVARPRICE;
	@JsonProperty("TOVARSUMMA")
	private Long TOVARSUMMA;
	@JsonProperty("EXPENSE")
	private Long EXPENSE;

	//    @Embedded
//	@JsonProperty("NOTE")
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<NOTE> NOTE;

	@JsonProperty("NOTE")
//	@OneToMany(cascade = CascadeType.ALL)
	private String NOTE;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty("SPLIT")
	private List<SPLIT> split;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty("PROPERTIES")
	private List<PROPERTIES> properties;
}