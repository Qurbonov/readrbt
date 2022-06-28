package uz.atm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
public class ClaimInfoEtpDto {

    @JsonProperty("lot_id")
    public String lotId;

    @JsonProperty("organ_name")
    public String organName;

    public Long summa;

    public Integer srok;

    public String purpose;

    public Integer state;

    @JsonProperty("proc_id")
    public Integer prodId;


}
