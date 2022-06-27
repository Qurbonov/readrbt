package uz.atm.repository.manualsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atm.model.manuals.ManExpGoods;

@Repository
public interface ManExpGoodsRepo extends JpaRepository<ManExpGoods, Long> {
}
