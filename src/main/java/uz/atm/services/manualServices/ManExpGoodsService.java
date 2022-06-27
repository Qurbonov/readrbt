package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManExpGoods;
import uz.atm.repository.manualsRepo.ManExpGoodsRepo;
import uz.atm.services.AbstractService;


@Service
public class ManExpGoodsService extends AbstractService<ManExpGoodsRepo> {

    public ManExpGoodsService(ManExpGoodsRepo repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ManExpGoods manExpGoods = mapper.readValue(json, ManExpGoods.class);
        repository.save(manExpGoods);
    }
}
