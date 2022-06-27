package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManOrganizations;
import uz.atm.repository.manualsRepo.ManOrganizationsRepo;
import uz.atm.services.AbstractService;

@Service
public class ManOrganizationsService extends AbstractService<ManOrganizationsRepo> {

    public ManOrganizationsService(ManOrganizationsRepo repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        ManOrganizations manOrganizations = mapper.readValue(json, ManOrganizations.class);
        repository.save(manOrganizations);
    }
}
