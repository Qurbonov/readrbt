package uz.atm.dto.auth;

import uz.atm.dto.GenericDto;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 11:45
 */
public class AuthResetPasswordDto extends GenericDto {

    public String oldPassword;

    public String newPassword;
}
