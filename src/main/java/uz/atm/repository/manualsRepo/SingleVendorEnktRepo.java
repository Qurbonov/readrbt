package uz.atm.repository.manualsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.manuals.SingleVendorEnkt;

@Repository
public interface SingleVendorEnktRepo extends JpaRepository<SingleVendorEnkt, Long> {
}
