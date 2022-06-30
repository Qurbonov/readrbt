package uz.atm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

public class ClaimInfoEtpDto {

    public Long id;

    @JsonProperty("lot_id")
    public Long lotId;

    @JsonProperty("organ_name")
    public String organName;

    public Long summa;

    public Integer srok;

    public String purpose;

    public Integer state;

    @JsonProperty("proc_id")
    public Integer prodId;

    @JsonProperty("inn")
    public Long inn;

    @JsonProperty("date1")
    public String date1;

    @JsonProperty("date2")
    public String date2;

    @JsonProperty("dvr")
    public Integer dvr;

}
