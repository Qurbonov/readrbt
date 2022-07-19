package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.atm.model.contactInfo.ContractInfo;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractInfoRepository extends JpaRepository<ContractInfo, Long> {

    List<ContractInfo> findAllByPayload_LotId(Long payload_lotId);

    @Query(value = "SELECT * FROM public.contract_info ci " +
            "where ci.state = 2 AND lot_id = :lot_id ORDER BY ci.version DESC LIMIT 1", nativeQuery = true)
    Optional<ContractInfo> findContractInfoByState(@Param("lot_id") Long lotId);
}
