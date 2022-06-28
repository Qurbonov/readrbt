package uz.atm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:15
 */
public class RequestEtpDto {

    private Long id;

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

}
