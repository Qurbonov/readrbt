package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.rkpEnd.RkpEnd;
import uz.atm.repository.RkpEndRepository;
import uz.atm.services.AbstractService;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class RkpEndService extends AbstractService<RkpEndRepository> {

    public RkpEndService(RkpEndRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        RkpEnd rkpEnd = mapper.readValue(json, new TypeReference<RkpEnd>() {
        });
        RkpEnd save = repository.save(rkpEnd);
    }
}
