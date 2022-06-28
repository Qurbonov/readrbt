package uz.atm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:07
 */
@AllArgsConstructor
@Getter
public enum Pltf {

    E_MAGAZIN(2),
    AUKSION(1);

    private final int code;

}
