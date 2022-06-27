package uz.atm.model.manuals;

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
public class ManOrganizations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identity;
    @JsonProperty("DIGEST_ID")
    private int digestId;
    @JsonProperty("REQUEST_ID")
    private int requestId;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("PAYLOAD")
    @Embedded
    private Payload payload;

    @Embeddable
    @Getter
    @Setter
    public static class Payload{
        @JsonProperty("ID")
        private String id;
        @JsonProperty("PAGENUM")
        private int pagenum;
        @JsonProperty("PAGECNT")
        private int pagecnt;
        @JsonProperty("DATA")
        @OneToMany(cascade=CascadeType.ALL)
        private List<Data> data;

        @Entity
        @Getter
        @Setter
        public static class Data{
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;
            @JsonProperty("CHANGE")
            private String change;
            @JsonProperty("FIN")
            private String fin;
            @JsonProperty("BUD")
            private int bud;
            @JsonProperty("ORGAN")
            private String organ;
            @JsonProperty("INN")
            private String inn;
            @JsonProperty("NAME")
            private String name;
            @JsonProperty("ADDRESS")
            private String address;
            @JsonProperty("OKONX")
            private String okonx;
            @JsonProperty("FONE_OFFICE")
            private String foneOffice;
            @JsonProperty("FAX_OFFICE")
            private String faxOffice;
            @JsonProperty("DIRECTOR")
            private String directory;
            @JsonProperty("FONE_DIREC")
            private String foneDirect;
            @JsonProperty("MOB_DIREC")
            private String mobDirect;
            @JsonProperty("BUXGALTER")
            private String buxgalter;
            @JsonProperty("FONE_BUX")
            private String foneBux;
            @JsonProperty("MOB_BUX")
            private String mobBux;
            @JsonProperty("STATE")
            private String state;
            @JsonProperty("DATEOPEN")
            private String dateOpen;
            @JsonProperty("DATECLOSE")
            private String dateClose;
            @JsonProperty("DATECHANGE")
            private String dateChange;
            @JsonProperty("EMAIL")
            private String email;
        }
    }
}
