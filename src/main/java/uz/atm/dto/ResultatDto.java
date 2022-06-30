package uz.atm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

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

    @JsonProperty("vendor_country")
    public String vendorCountry;

    @JsonProperty("vendor_inn")
    public Long vendorInn;

    @JsonProperty("vendor_name")
    public String vendorName;

    @JsonProperty("contract_beg")
    public Date contractBeg;

    @JsonProperty("contract_end")
    public Date contractEnd;

    @JsonProperty("avans_day")
    public Integer avansDay;

    @JsonProperty("etp_id")
    public Integer etpId;

    @JsonProperty("purpose")
    public String purpose;

    @JsonProperty("vendor_acc")
    public String vendorAcc;

    @JsonProperty("vendor_bank")
    public Integer vendorBank;

    @JsonProperty("contract_num")
    public String contractNum;

    @JsonProperty("p_avans")
    public String pAvans;

    @JsonProperty("beneficiar")
    public String beneficiar;

}
