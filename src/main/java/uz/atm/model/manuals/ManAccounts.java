package uz.atm.model.manuals;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ManAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identity;
    @JsonProperty("DIGEST_ID")
    private int digestId;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("PAYLOAD")
    @Embedded
    private Payload payload;

    @Embeddable
    @Getter
    @Setter
    private static class Payload {
        @JsonProperty("ID")
        private String id;
        @JsonProperty("PAGENUM")
        private int pageNum;
        @JsonProperty("PAGECNT")
        private int pageCnt;
        @JsonProperty("DATA")
        @OneToMany(cascade = CascadeType.ALL)
        private List<Data> data;

        @Entity
        @Getter
        @Setter
        private static class Data {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;
            @JsonProperty("CHANGE")
            private String change;
            @JsonProperty("FIN")
            private String fIN;
            @JsonProperty("BUD")
            private int bud;
            @JsonProperty("ORGAN")
            private String organ;
            @JsonProperty("INN")
            private String inn;
            @JsonProperty("LICACC")
            private String licAcc;
            @JsonProperty("TERRITORY")
            private String territory;
            @JsonProperty("NAME")
            private String name;
            @JsonProperty("STATE")
            private String state;
            @JsonProperty("DATEOPEN")
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
            private String dateOpen;
            @JsonProperty("DATECLOSE")
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
            private String dateClose;
            @JsonProperty("DATECHANGE")
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
            private String dateChange;
            @JsonProperty("KLSTYPE")
            private String klsType;
        }
    }
}
