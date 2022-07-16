package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.exceptions.JsonParserException;
import uz.atm.model.rkpPays.RkpPays;
import uz.atm.repository.RkpPaysRepository;
import uz.atm.services.AbstractService;

@Service
public class RkpPaysService extends AbstractService<RkpPaysRepository> {
    public RkpPaysService(RkpPaysRepository repository) {
        super(repository);
    }

    public void save(String json) {
        try {
            RkpPays rkpPays = mapper.readValue(json, RkpPays.class);
            repository.save(rkpPays);
        } catch (JsonProcessingException e) {
            throw new JsonParserException(e.getMessage());
        }
    }
}
