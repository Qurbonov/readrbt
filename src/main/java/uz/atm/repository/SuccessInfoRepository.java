package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.successInfo.SuccessInfo;
@Repository
public interface SuccessInfoRepository extends JpaRepository<SuccessInfo, Long> {
}
