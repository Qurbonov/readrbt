package uz.atm.criteria;

import lombok.Getter;
import lombok.Setter;

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

    private Long summa;

    private Long procId;


}
