package uz.atm.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 29/06/22
 * Time: 15:11
 */
@Getter
@Setter
public class ClaimInfoCriteria {

    @JsonProperty("lot_id")
    private Long lotId;

    @JsonProperty("organ_name")
    private String organName;

    private Long summaFrom;

    private Long summaTo;

    private Integer srok;

    private Integer state;

    @JsonProperty("proc_id")
    private Integer prodId;


}
