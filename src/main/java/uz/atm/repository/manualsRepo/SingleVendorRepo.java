package uz.atm.repository.manualsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.manuals.SingleVendor;

@Repository
public interface SingleVendorRepo extends JpaRepository<SingleVendor, Long> {
}
