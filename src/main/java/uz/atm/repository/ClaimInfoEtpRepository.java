package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.clalimInfo.ClaimInfoEtp;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:52
 */
@Repository
public interface ClaimInfoEtpRepository extends JpaRepository<ClaimInfoEtp, Long> {
}
