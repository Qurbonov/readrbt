package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.repository.ResultatMethodRepository;
import uz.atm.services.AbstractService;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

@Service
public class ResultatService extends AbstractService<ResultatMethodRepository> {

    public ResultatService(ResultatMethodRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ResultatMethod resultatMethod = mapper.readValue(json, new TypeReference<ResultatMethod>() {
        });
        ResultatMethod save = repository.save(resultatMethod);
    }
}
