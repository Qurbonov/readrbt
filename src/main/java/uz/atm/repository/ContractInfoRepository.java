package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.contactInfo.ContractInfo;

import java.util.List;
import java.util.Optional;
@Repository
public interface ContractInfoRepository extends JpaRepository<ContractInfo, Long> {

    List<ContractInfo> findAllByPayload_LotId(Long payload_lotId);
}
