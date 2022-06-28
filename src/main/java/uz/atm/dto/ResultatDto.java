package uz.atm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
public class ResultatDto {

    public Long id;

    @JsonProperty("lot_id")
    public Long lotId;

    public Integer state;

    @JsonProperty("organ_name")
    public String organName;

    public String maloy;

    public Long summa;

    @JsonProperty("proc_id")
    public Integer procId;

    @JsonProperty("contract_dat")
    public Date contractDate;

}
