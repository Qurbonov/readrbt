package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.atm.dto.ResultatDto;
import uz.atm.model.resultat.ResultatMethod;

import java.time.LocalDate;
import java.util.List;

public interface ResultatMethodRepository extends JpaRepository<ResultatMethod, Long> {

    @Query(value = "select public.get_resultat(:lotId,:state,:organName,:maloy,:summaFrom,:summaTo,:locDate1,:locDate2);", nativeQuery = true)
    List<ResultatDto> findByCriteria(@Param("lotId") String lotId, @Param("state") String state,
                                     @Param("organName") String organName, @Param("maloy") String maloy,
                                     @Param("summaFrom") Long summaFrom, @Param("summaTo") Long summaTo,
                                     @Param("locDate1") LocalDate locDate1, @Param("locDate2") LocalDate locDate2);
}
