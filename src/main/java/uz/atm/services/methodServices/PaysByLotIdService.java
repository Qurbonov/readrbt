package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.exceptions.JsonParserException;
import uz.atm.model.paysByLotId.PaysByLotId;
import uz.atm.model.responseAuction.ResponseAuction;
import uz.atm.repository.PaysByLotIdRepository;
import uz.atm.services.AbstractService;

@Service
public class PaysByLotIdService extends AbstractService<PaysByLotIdRepository> {

    public PaysByLotIdService(PaysByLotIdRepository repository) {
        super(repository);
    }


    public void save(String json) {
        try {
            PaysByLotId paysByLotId = mapper.readValue(json, PaysByLotId.class);
            repository.save(paysByLotId);
        } catch (JsonProcessingException e) {
            throw new JsonParserException(e);
        }

    }
}
