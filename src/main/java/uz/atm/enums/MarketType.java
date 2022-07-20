package uz.atm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 20/07/22
 * Time: 14:42
 */
@AllArgsConstructor
@Getter
public enum MarketType {
    TRANSACTIONCOMPLETED(3),
    DIGITALCATALOGUE(6),
    TENDER(17),
    DIRECTCONTRACTS(19),
    KONKURS(18);

    private final Integer code;

}
