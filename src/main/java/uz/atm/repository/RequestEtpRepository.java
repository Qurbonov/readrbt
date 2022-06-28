package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.atm.model.requestEtp.RequestEtp;

import java.util.Date;

public interface RequestEtpRepository extends JpaRepository<RequestEtp, Long> {


    @Query(value = "select public.get_request_etp(:lotId,:docDateFrom,:docDateTo,:organName,:sumLotFrom,:sumLotTo,:month,:state,:pltf);", nativeQuery = true)
    String findByCriteria(
            @Param("docDateFrom") Date docDateFrom, @Param("docDateTo") Date docDateTo, @Param("lotId") Long lotId,
            @Param("month") Integer month, @Param("sumLotTo") Long sumLotTo, @Param("sumLotFrom") Long sumLotFrom,
            @Param("organName") String organName, @Param("pltf") Integer pltf, @Param("state") Integer state);
}
