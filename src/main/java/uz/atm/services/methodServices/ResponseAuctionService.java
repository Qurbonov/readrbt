package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.exceptions.JsonParserException;
import uz.atm.model.responseAuction.ResponseAuction;
import uz.atm.model.responseClaimInfo.ResponseClaimInfo;
import uz.atm.repository.ResponseAuctionRepository;
import uz.atm.services.AbstractService;

@Service
public class ResponseAuctionService extends AbstractService<ResponseAuctionRepository> {

    public ResponseAuctionService(ResponseAuctionRepository repository) {
        super(repository);
    }

    public void save(String json) {
        try {
            ResponseAuction responseAuction = mapper.readValue(json, ResponseAuction.class);
            repository.save(responseAuction);
        } catch (JsonProcessingException e) {
            throw new JsonParserException(e.getMessage());
        }

    }
}
