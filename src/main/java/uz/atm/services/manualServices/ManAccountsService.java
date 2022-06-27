package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManAccounts;
import uz.atm.repository.manualsRepo.ManAccountsRepo;
import uz.atm.services.AbstractService;

@Service
public class ManAccountsService extends AbstractService<ManAccountsRepo> {

    public ManAccountsService(ManAccountsRepo repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ManAccounts manAccounts = mapper.readValue(json, ManAccounts.class);
        repository.save(manAccounts);
    }
}
