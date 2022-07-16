package uz.atm.dto.methods;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

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
    public Date date1;

    @JsonProperty("date2")
    public Date date2;

    @JsonProperty("dvr")
    public Integer dvr;

}
