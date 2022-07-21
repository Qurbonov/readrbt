package uz.atm.dto.methods.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public interface ClaimInfoMapper {
    Long getId();

    Long getLotId();//+

    String getOrganName(); //?

    Long getSumma();//+

    Integer getSrok(); //?

    String getPurpose();//+

    Integer getState(); //?

    Integer getProdId(); //+

    Long getInn();//+

    Date getDate1(); //+

    Date getDate2(); //+

    Integer getDvr(); //+
}
