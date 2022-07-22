package uz.atm.dto.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.atm.dto.GenericDto;

import java.util.Date;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:15
 */
public class RequestEtpDto extends GenericDto {

    @JsonProperty("lot_id")
    public Long lotId;

    @JsonProperty("doc_date")
    public Date docDate;

    @JsonProperty("organ_name")
    public String organName;

    @JsonProperty("sum_lot")
    public Long sumLot;

    public Integer month;

    public Integer state;

    public Integer pltf;

    @JsonProperty("etp_id")
    public Integer etpId;

    @JsonProperty("acc")
    public String acc;

}
