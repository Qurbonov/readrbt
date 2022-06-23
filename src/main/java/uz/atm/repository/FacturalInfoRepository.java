package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.facturaInfo.FacturaInfo;

public interface FacturalInfoRepository extends JpaRepository<FacturaInfo, Long> {
}
