package uz.atm.repository;

import org.springframework.data.repository.CrudRepository;
import uz.atm.model.resultat.ResultatMethod;

public interface RbtMsgsRepository extends CrudRepository<ResultatMethod, Long> {
}
