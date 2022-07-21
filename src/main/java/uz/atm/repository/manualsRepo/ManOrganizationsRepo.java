package uz.atm.repository.manualsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atm.model.manuals.ManOrganizations;

import java.util.Optional;

@Repository
public interface ManOrganizationsRepo extends JpaRepository<ManOrganizations, Long> {


    @Query(value = "select mpd.name from man_organizations mo inner join man_organizations_data mod on mo.identity = mod.man_organizations_identity\n" +
            "inner join man_organizations$payload$data mpd on mpd.id = mod.data_id where organ= :organ_code",nativeQuery = true)
    String getNameByOrgan(@Param("organ_code") String organ);
}
