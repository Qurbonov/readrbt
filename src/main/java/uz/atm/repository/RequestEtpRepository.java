package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.requestEtp.RequestEtp;

public interface RequestEtpRepository extends JpaRepository<RequestEtp, Long> {
}
