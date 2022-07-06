package uz.atm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 12:58
 */
@AllArgsConstructor
@Getter
public enum BlackListStatus {

    BLOCK(0),
    UNBLOCK(1);

    private final int code;

}
