package uz.atm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.resultat.ResultatMethod;
@Repository
public interface RbtMsgsRepository extends CrudRepository<ResultatMethod, Long> {
}
