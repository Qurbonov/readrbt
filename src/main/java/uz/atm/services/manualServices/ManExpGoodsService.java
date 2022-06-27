package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManExpGoods;
import uz.atm.repository.manualsRepo.ManExpGoodsRepo;


@Service
@RequiredArgsConstructor
public class ManExpGoodsService {
    private final ManExpGoodsRepo repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public void save(String json) throws JsonProcessingException {
        ManExpGoods manExpGoods = mapper.readValue(json, ManExpGoods.class);
        repo.save(manExpGoods);
    }
}
