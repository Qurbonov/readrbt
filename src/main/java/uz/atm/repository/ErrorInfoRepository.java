package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.errorInfo.ErrorInfo;

public interface ErrorInfoRepository extends JpaRepository<ErrorInfo, Long> {
}
