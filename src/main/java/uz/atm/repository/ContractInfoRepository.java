package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.contactInfo.ContractInfo;

import java.util.Optional;

public interface ContractInfoRepository extends JpaRepository<ContractInfo, Long> {

    Optional<ContractInfo> findByPayload_LotId(Long payload_lotId);
}
