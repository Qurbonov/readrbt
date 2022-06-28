package uz.atm.criteria;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 12:00
 */

@Getter
@Setter
public class RequestEtpCriteria {

    private Long lotId;

    private Date docDateFrom;

    private Date docDateTo;

    private String organName;

    private Long sumLotFrom;

    private Long sumLotTo;

    private Integer month;

    private Integer state;

    private Integer pltf;
}
