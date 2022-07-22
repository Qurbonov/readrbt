package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.blackList.BlackList;

import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 14:51
 */
public interface BlackListRepository extends JpaRepository<BlackList, Long> {

    List<BlackList> findAllByStatus(Integer status);
}
