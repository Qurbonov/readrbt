package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atm.model.clalimInfo.ClaimInfoEtp;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:52
 */
@Repository
public interface ClaimInfoEtpRepository extends JpaRepository<ClaimInfoEtp, Long> {
    @Query(value = "select public.nimadr()", nativeQuery = true)
    String getByCriteria(@Param("lotId") Long lotId, @Param("organName") String organName, @Param("prodId") Integer prodId,
                         @Param("srok") Integer srok, @Param("state") Integer state, @Param("summaFrom") Long summaFrom, @Param("summaTo") Long summaTo);
}
