package uz.atm.repository.manualsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.manuals.ManAccounts;

@Repository
public interface ManAccountsRepo extends JpaRepository<ManAccounts, Long> {
}
