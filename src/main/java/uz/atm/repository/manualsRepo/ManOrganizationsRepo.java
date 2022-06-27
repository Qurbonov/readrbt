package uz.atm.repository.manualsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.manuals.ManOrganizations;

@Repository
public interface ManOrganizationsRepo extends JpaRepository<ManOrganizations, Long> {

}
