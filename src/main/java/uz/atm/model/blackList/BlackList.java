package uz.atm.model.blackList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import uz.atm.enums.BlackListStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 12:35
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("INN")
    private String inn;

    @JsonProperty("NAME")
    private String orgName;

    @JsonProperty("DATE_BEGIN")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date dateBegin;

    @JsonProperty("DATE_END")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "ddMMyyyy")
    private Date dateEnd;

    @JsonProperty("STATUS")
    private Integer status = BlackListStatus.BLOCK.getCode();

    @JsonProperty("NOTE")
    @Column(columnDefinition = "TEXT")
    private String note;
}
