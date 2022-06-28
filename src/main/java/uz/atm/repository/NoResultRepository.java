package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.noResult.NoResult;
@Repository
public interface NoResultRepository extends JpaRepository<NoResult, Long> {
}
