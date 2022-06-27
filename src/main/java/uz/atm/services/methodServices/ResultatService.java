package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.ResultatCollectedDto;
import uz.atm.dto.ResultatDto;
import uz.atm.model.contactInfo.ContractInfo;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.repository.ContractInfoRepository;
import uz.atm.repository.ResultatMethodRepository;
import uz.atm.services.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

@Service
public class ResultatService extends AbstractService<ResultatMethodRepository> {

    private final ContractInfoRepository contractInfoRepository;

    public ResultatService(ResultatMethodRepository repository, ContractInfoRepository contractInfoRepository) {
        super(repository);
        this.contractInfoRepository = contractInfoRepository;
    }

    public void save(String json) throws JsonProcessingException {
        ResultatMethod resultatMethod = mapper.readValue(json, new TypeReference<ResultatMethod>() {
        });
        ResultatMethod save = repository.save(resultatMethod);
    }

    public List<ResultatDto> getAllByCriteria(ResultatCriteria r) {
        try {
            return repository.findByCriteria(r.getLotId(), r.getState(), r.getOrganName(), r.getMaloy(), r.getSummaFrom(), r.getSummaTo(),r.getProcId(), r.getFromDate(), r.getToDate());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Optional<ResultatCollectedDto> getById(Long id) {
        ResultatCollectedDto resultatCollectedDto = new ResultatCollectedDto();
        Optional<ResultatMethod> byId = repository.findById(id);
        if (byId.isPresent()) {
            ResultatMethod resultatMethod = byId.get();
            resultatCollectedDto.resultat = resultatMethod;
            Long lotId = resultatMethod.getPayload().getLotId();
            Optional<ContractInfo> byPayload_lotId = contractInfoRepository.findByPayload_LotId(lotId);
            byPayload_lotId.ifPresent(contractInfo -> resultatCollectedDto.contractInfo = contractInfo);
            return Optional.of(resultatCollectedDto);
        } else return Optional.empty();
    }
}
