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

    private Integer state;

    private String organName;

    private String maloy;

    private Long summaFrom;

    private Long summaTo;

    private Integer procId;

    public LocalDate fromDate;

    public LocalDate toDate;




}
