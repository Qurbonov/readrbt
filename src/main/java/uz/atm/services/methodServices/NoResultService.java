package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.model.noResult.NoResult;
import uz.atm.repository.NoResultRepository;
import uz.atm.services.AbstractService;

@Service
public class NoResultService extends AbstractService<NoResultRepository> {
    public NoResultService(NoResultRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        NoResult noResult = mapper.readValue(json, NoResult.class);
        repository.save(noResult);
    }
}
