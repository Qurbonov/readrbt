package uz.atm.criteria;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Getter
@Setter
public class ResultatCriteria extends GenericCriteria {

    private String lotId;

    private String state;

    private String organName;

    private String maloy;

    private Long summaFrom;

    private Long summaTo;

    public LocalDate locDate1;

    public LocalDate locDate2;




}
