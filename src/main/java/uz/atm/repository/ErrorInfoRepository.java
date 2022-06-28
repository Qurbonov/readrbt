package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.errorInfo.ErrorInfo;
@Repository
public interface ErrorInfoRepository extends JpaRepository<ErrorInfo, Long> {
}
