package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atm.model.resultat.Specifications;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications, Long> {
    @Query(value = "SELECT s.id,\n" +
            "       expense, fin_year,\n" +
            "       kls, npos, tovar,\n" +
            "       tovar_amount, tovar_edizm,\n" +
            "       tovar_name,tovar_note,\n" +
            "       tovar_price, tovar_summa\n" +
            "        from specifications s inner join resultat_method_specifications rms\n" +
            "        ON s.id = rms.specifications_id WHERE rms.resultat_method_id = :resultat_id", nativeQuery = true)
    Optional<List<Specifications>> findSpecificationsByResultatId(@Param("resultat_id") long id);

    @Query(value = "SELECT s.id,\n" +
            "       expense, fin_year,\n" +
            "       kls, npos, tovar,\n" +
            "       tovar_amount, tovar_edizm,\n" +
            "       tovar_name,tovar_note,\n" +
            "       tovar_price, tovar_summa\n" +
            "        from specifications s inner join postgres.public.request_etp_specifications res \n" +
            "        ON s.id = res.specifications_id WHERE res.request_etp_id = :request_etp_id", nativeQuery = true)
    Optional<List<Specifications>> findSpecificationsByRequestEtpId(@Param("request_etp_id") long id);

    @Query(value = "SELECT s.id,\n" +
            "       expense, fin_year,\n" +
            "       kls, npos, tovar,\n" +
            "       tovar_amount, tovar_edizm,\n" +
            "       tovar_name,tovar_note,\n" +
            "       tovar_price, tovar_summa\n" +
            "        from specifications s inner join postgres.public.claim_info_etp_specifications cis \n" +
            "        ON s.id = cis.specifications_id WHERE cis.claim_info_etp_id = :claim_info_etp_id", nativeQuery = true)
    Optional<List<Specifications>> findSpecificationsByClaimInfoEtpId(@Param("claim_info_etp_id") long id);
}
