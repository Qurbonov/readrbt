package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.rkpEnd.RkpEnd;
@Repository

public interface RkpEndRepository extends JpaRepository<RkpEnd, Long> {
}
