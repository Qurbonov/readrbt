package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.contactInfo.ContractInfo;
import uz.atm.repository.ContractInfoRepository;
import uz.atm.services.AbstractService;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class ContractInfoService extends AbstractService<ContractInfoRepository> {

    public ContractInfoService(ContractInfoRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ContractInfo contractInfo = mapper.readValue(json, new TypeReference<ContractInfo>() {
        });
        ContractInfo save = repository.save(contractInfo);
    }
}
