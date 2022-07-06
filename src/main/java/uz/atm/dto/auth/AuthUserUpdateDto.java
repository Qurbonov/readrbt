package uz.atm.dto.auth;

import uz.atm.dto.GenericDto;
import uz.atm.enums.Role;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:31
 */
public class AuthUserUpdateDto extends GenericDto {

    public String username;

    public String firstName;

    public String lastName;

    public String management;

    public String department;

    public String position;

}
