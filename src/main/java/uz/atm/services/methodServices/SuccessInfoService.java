package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.rkpEnd.RkpEnd;
import uz.atm.model.successInfo.SuccessInfo;
import uz.atm.repository.SuccessInfoRepository;
import uz.atm.services.AbstractService;

@Service
public class SuccessInfoService extends AbstractService<SuccessInfoRepository> {

    public SuccessInfoService(SuccessInfoRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        SuccessInfo successInfo = mapper.readValue(json, SuccessInfo.class);
        repository.save(successInfo);
    }
}
