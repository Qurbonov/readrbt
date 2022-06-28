package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.model.responseClaimInfo.ResponseClaimInfo;
import uz.atm.repository.ResponseClaimInfoRepository;
import uz.atm.services.AbstractService;

@Service
public class ResponseClaimInfoService extends AbstractService<ResponseClaimInfoRepository> {

    public ResponseClaimInfoService(ResponseClaimInfoRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ResponseClaimInfo responseClaimInfo = mapper.readValue(json, ResponseClaimInfo.class);
        repository.save(responseClaimInfo);
    }
}
