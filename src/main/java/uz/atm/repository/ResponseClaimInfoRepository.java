package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.responseClaimInfo.ResponseClaimInfo;
@Repository
public interface ResponseClaimInfoRepository extends JpaRepository<ResponseClaimInfo, Long> {
}
