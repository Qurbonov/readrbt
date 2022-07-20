package uz.atm.dto.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 20/07/22
 * Time: 16:52
 */
public class MarketInfoDto {

    @JsonProperty("etp_id")
    public Integer etpId;

    @JsonProperty("count")
    public Integer count;

}
