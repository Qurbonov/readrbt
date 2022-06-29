package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.criteria.ClaimInfoCriteria;
import uz.atm.dto.ClaimInfoEtpDto;
import uz.atm.model.clalimInfo.ClaimInfoEtp;
import uz.atm.repository.ClaimInfoEtpRepository;
import uz.atm.services.AbstractService;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 28/06/22
 * Time: 11:50
 */
@Service
public class ClaimInfoEtpService extends AbstractService<ClaimInfoEtpRepository> {


    public ClaimInfoEtpService(ClaimInfoEtpRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ClaimInfoEtp claimInfoEtp = mapper.readValue(json, new TypeReference<ClaimInfoEtp>() {
        });
        ClaimInfoEtp save = repository.save(claimInfoEtp);
    }

    public Optional<List<ClaimInfoEtpDto>> getByCriteria(ClaimInfoCriteria c) {
        try {
            String dataJson = repository.getByCriteria(c.getLotId(), c.getOrganName(),
                    c.getProcId(), c.getSrok(), c.getState(),
                    c.getSummaFrom(), c.getSummaTo());
            List<ClaimInfoEtpDto> claimInfoEtpDtos = mapper.readValue(dataJson, new TypeReference<List<ClaimInfoEtpDto>>() {
            });
            return Optional.of(claimInfoEtpDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }
}
