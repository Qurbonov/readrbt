package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManAccounts;
import uz.atm.repository.manualsRepo.ManAccountsRepo;

@Service
@RequiredArgsConstructor
public class ManAccountsService {
    private final ManAccountsRepo repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public void save(String json) throws JsonProcessingException{
        ManAccounts manAccounts = mapper.readValue(json, ManAccounts.class);
        repository.save(manAccounts);
    }
}
