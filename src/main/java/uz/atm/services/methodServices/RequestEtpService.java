package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.requestEtp.RequestEtp;
import uz.atm.repository.RequestEtpRepository;
import uz.atm.services.AbstractService;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class RequestEtpService extends AbstractService<RequestEtpRepository> {

    public RequestEtpService(RequestEtpRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        RequestEtp requestEtp = mapper.readValue(json, new TypeReference<RequestEtp>() {
        });
        RequestEtp save = repository.save(requestEtp);
    }

}
