package uz.atm.dto.auth;

import uz.atm.dto.BaseDto;
import uz.atm.enums.Role;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:19
 */
public class AuthUserCreateDto implements BaseDto {

    public String username;

    public String password;

    public Role role;

    public String firstName;

    public String lastName;

    public String management;

    public String department;

    public String position;

}
