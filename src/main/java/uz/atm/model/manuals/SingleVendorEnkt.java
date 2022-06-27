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
public class SingleVendorEnkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
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
    private static class Payload{
        @JsonProperty("ID")
        private String id;
        @JsonProperty("PAGENUM")
        private int pageNum;
        @JsonProperty("PAGECNT")
        private int PageCnt;
        @JsonProperty("DATA")
        @OneToMany(cascade=CascadeType.ALL)
        private List<Data> data;

        @Entity
        @Getter
        @Setter
        private static class Data{
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;
            @JsonProperty("CHANGE")
            private String change;
            @JsonProperty("INN")
            private String inn;
            @JsonProperty("ENKT")
            public String enkt;
            @JsonProperty("STATE")
            private String state;
            @JsonProperty("DATEOPEN")
            private String dateOpen;
            @JsonProperty("DATECLOSE")
            private String dateClose;
            @JsonProperty("DATECHANGE")
            private String dateChange;
        }
    }

}
