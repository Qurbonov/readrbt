package uz.atm.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.enums.Role;
import uz.atm.enums.Status;
import uz.atm.model.Auditable;

import javax.persistence.Entity;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 09:52
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser extends Auditable {

    private String username;

    private String password;

    private Role role;

    private String firstName;

    private String lastName;

    private String management;

    private String department;

    private String position;

    private Status status;

}
