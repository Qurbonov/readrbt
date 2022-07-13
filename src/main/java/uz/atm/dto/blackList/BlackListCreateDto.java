package uz.atm.dto.blackList;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 15:13
 */
public class BlackListCreateDto {

    public String inn;

    public String orgName;

    public Date dateBegin;

    public Date dateEnd;

    public String note;


}
