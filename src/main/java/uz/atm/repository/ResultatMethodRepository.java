package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.atm.dto.ResultatDto;
import uz.atm.model.resultat.ResultatMethod;

import java.util.List;

public interface ResultatMethodRepository extends JpaRepository<ResultatMethod, Long> {

    @Query(value = "select public.get_nimadr()", nativeQuery = true)
    List<ResultatDto> findByCriteria(@Param("lotId") String lotId, @Param("state") String state,
                                     @Param("organName") String organName, @Param("maloy") String maloy,
                                     @Param("summaFrom") Long summaFrom, @Param("summaTo") Long summaTo);
}
