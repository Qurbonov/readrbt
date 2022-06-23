package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.contactInfo.ContractInfo;

public interface ContractInfoRepository extends JpaRepository<ContractInfo, Long> {
}
