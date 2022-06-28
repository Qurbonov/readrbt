package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;
import uz.atm.model.clalimInfo.ClaimInfoEtp;
import uz.atm.repository.ClaimInfoEtpRepository;
import uz.atm.services.AbstractService;

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
}
