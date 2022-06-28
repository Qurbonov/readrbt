package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atm.model.resultat.ResultatMethod;

import java.time.LocalDate;
@Repository
public interface ResultatMethodRepository extends JpaRepository<ResultatMethod, Long> {

    @Query(value = "select public.get_resultat(:lotId,:state,:organName,:maloy,:summaFrom,:summaTo,:procId,:fromDate,:toDate);", nativeQuery = true)
    String findByCriteria(@Param("lotId") Long lotId, @Param("state") Integer state,
                          @Param("organName") String organName, @Param("maloy") String maloy,
                          @Param("summaFrom") Long summaFrom, @Param("summaTo") Long summaTo,
                          @Param("procId") Integer procId, @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}
