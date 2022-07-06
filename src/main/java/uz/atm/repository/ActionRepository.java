package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.action.Actions;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 15:00
 */
public interface ActionRepository extends JpaRepository<Actions, Long> {
}
