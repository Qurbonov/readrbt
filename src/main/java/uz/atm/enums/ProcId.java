package uz.atm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:08
 */
@AllArgsConstructor
@Getter
public enum ProcId {

    TENDER(1),
    KONKURS(2);

    private final int code;
}
