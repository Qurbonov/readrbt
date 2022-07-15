package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atm.model.resultat.ResultatMethod;

import java.time.LocalDate;

@Repository
public interface ResultatMethodRepository extends JpaRepository<ResultatMethod, Long> {

    @Query(value = "select public.get_resultat(:etpId,:lotId,:organName,:organInn,:maloy,:vendorInn,:vendorName,:contractNum,:procId,:fromDate,:toDate,:sizee,:page);", nativeQuery = true)
    String findByCriteria(@Param("etpId") Integer etpId,@Param("lotId") Long lotId, @Param("organName") String organName, @Param("organInn") String organInn,
                          @Param("maloy") String maloy, @Param("vendorInn") String vendorInn, @Param("vendorName") String vendorName,
                          @Param("contractNum") String contractNum, @Param("procId") Integer procId, @Param("fromDate") LocalDate fromDate,
                          @Param("toDate") LocalDate toDate, @Param("sizee") Integer sizee, @Param("page") Integer page);
}
