package uz.atm.model.facturaInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.model.DateEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacturaInfo extends DateEntity {

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
	private FacturaInfoInfoPayload payload;

	@Data
	@Embeddable
	@AllArgsConstructor
	@NoArgsConstructor
	static class FacturaInfoInfoPayload {

		@JsonProperty("COUNTS")
		private Integer counts;

		@JsonProperty("RECORDS")
		@OneToMany(cascade = CascadeType.ALL)
		private List<Records> records;
	}

}


/*
{
  "RESPONSE_ID": 3547871,
  "REQUEST_ID": 2195221,
  "METHOD_NAME": "FACTURA_INFO",
  "PAYLOAD": {
    "COUNTS": 1,
    "RECORDS": [
      {
        "INVOICEID": 30283693,
        "LOTID": 22110012108312,
        "CONTRACT": 30062363,
        "KLS": "401722860302157065200110017",
        "NUMBINVOICE": "1",
        "DATEINVOICE": "14072022",
        "CONAME": "Бешарик ТЙФУК",
        "COINN": "200154776",
        "DATEDOC": "27062022",
        "SUMPAY": 28979835501,
        "NAMEWARRANT": "",
        "STATE": 2,
        "GEN_ID": 0,
        "SPECIFICATIONS": [
          {
            "NPOS": 1,
            "TOVAR": "42.11.20.000-00010",
            "TOVARNAME": "Услуга по текущему ремонту автомобильных дорог",
            "TOVAREDIZM": "25",
            "TOVARAMOUNT": 1,
            "TOVARPRICE": 25199856957,
            "TOVARSUMMA": 28979835501,
            "EXPENSE": "44233100"
          }
        ]
      }
    ]
  }
}
*/