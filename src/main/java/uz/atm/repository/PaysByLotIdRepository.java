package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.paysByLotId.PaysByLotId;

public interface PaysByLotIdRepository extends JpaRepository<PaysByLotId, Long> {
}
