package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.errorInfo.ErrorInfo;
import uz.atm.repository.ErrorInfoRepository;
import uz.atm.services.AbstractService;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class ErrorInfoService extends AbstractService<ErrorInfoRepository> {

    public ErrorInfoService(ErrorInfoRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ErrorInfo errorInfo = mapper.readValue(json, new TypeReference<ErrorInfo>() {
        });
        ErrorInfo save = repository.save(errorInfo);
    }
}
