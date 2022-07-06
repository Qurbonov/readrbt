package uz.atm.model.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.atm.enums.ActionMessage;
import uz.atm.model.Auditable;

import javax.persistence.Entity;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 09:58
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actions extends Auditable {

    private String message;

    private Long ownerId;

}
