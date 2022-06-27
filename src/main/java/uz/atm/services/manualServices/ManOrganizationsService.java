package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManOrganizations;
import uz.atm.repository.manualsRepo.ManOrganizationsRepo;

@Service
@RequiredArgsConstructor
public class ManOrganizationsService {
    private final ManOrganizationsRepo repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public void save(String json) throws JsonProcessingException {
        ManOrganizations manOrganizations = mapper.readValue(json, ManOrganizations.class);
        repo.save(manOrganizations);
    }
}
