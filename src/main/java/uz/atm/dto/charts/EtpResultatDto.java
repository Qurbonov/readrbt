package uz.atm.dto.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 20/07/22
 * Time: 16:52
 */
public class EtpResultatDto {

    @JsonProperty("transaction_completed_info")
    public List<MarketInfoDto> transactionCompletedInfo;

    @JsonProperty("digital_catalogue_info")
    public List<MarketInfoDto> digitalCatalogueInfo;

    @JsonProperty("tender_info")
    public List<MarketInfoDto> tenderInfo;

    @JsonProperty("konkurs_info")
    public List<MarketInfoDto> konkursInfo;

    @JsonProperty("direct_contracts_info")
    public List<MarketInfoDto> directContractsInfo;

    public EtpResultatDto() {
        this.transactionCompletedInfo = new ArrayList<>();
        this.digitalCatalogueInfo = new ArrayList<>();
        this.tenderInfo = new ArrayList<>();
        this.konkursInfo = new ArrayList<>();
        this.directContractsInfo = new ArrayList<>();
    }
}
