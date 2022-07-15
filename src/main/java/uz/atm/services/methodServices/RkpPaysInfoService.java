package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.exceptions.JsonParserException;
import uz.atm.model.rkpPaysInfo.RkpPaysInfo;
import uz.atm.repository.RkpPaysInfoRepository;
import uz.atm.services.AbstractService;

@Service
public class RkpPaysInfoService extends AbstractService<RkpPaysInfoRepository> {

    public RkpPaysInfoService(RkpPaysInfoRepository repository) {
        super(repository);
    }

    public void save(String json) {
        try {
            RkpPaysInfo rkpPaysInfo = mapper.readValue(json, RkpPaysInfo.class);
            repository.save(rkpPaysInfo);
        } catch (JsonProcessingException e) {
            throw new JsonParserException(e);
        }

    }
}
