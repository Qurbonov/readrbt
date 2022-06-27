package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.facturaInfo.FacturaInfo;
import uz.atm.repository.FacturalInfoRepository;
import uz.atm.services.AbstractService;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class FacturaInfoService extends AbstractService<FacturalInfoRepository> {

    public FacturaInfoService(FacturalInfoRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        FacturaInfo facturalInfo = mapper.readValue(json, new TypeReference<FacturaInfo>() {
        });
        FacturaInfo save = repository.save(facturalInfo);
    }
}
