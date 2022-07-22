package uz.atm.criteria;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Getter
@Setter
public class ResultatCriteria extends GenericCriteria {

    private Long lotId;

    private String organName;

    private String organInn;

    private String vendorName;

    private String vendorInn;

    private String contractNum;

    private String maloy;

    private Integer procId;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Integer etpId;




}
