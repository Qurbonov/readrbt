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


    @Query(value = "select public.get_claim_info(:lotId,:organName,:summaFrom,:summaTo,:srok,:state,:procId,:size,:page);", nativeQuery = true)
    String getByCriteria(@Param("lotId") Long lotId, @Param("organName") String organName, @Param("procId") Integer procId,
                         @Param("srok") Integer srok, @Param("state") Integer state, @Param("summaFrom") Long summaFrom,
                         @Param("summaTo") Long summaTo, @Param("size") Integer size, @Param("page") Integer page);

}
