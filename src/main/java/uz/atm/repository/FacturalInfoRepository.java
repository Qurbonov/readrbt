package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.facturaInfo.FacturaInfo;
@Repository
public interface FacturalInfoRepository extends JpaRepository<FacturaInfo, Long> {
}
