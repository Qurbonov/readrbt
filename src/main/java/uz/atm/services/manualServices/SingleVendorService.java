package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.SingleVendor;
import uz.atm.repository.manualsRepo.SingleVendorRepo;
import uz.atm.services.AbstractService;


@Service
public class SingleVendorService extends AbstractService<SingleVendorRepo> {

    public SingleVendorService(SingleVendorRepo repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        SingleVendor singleVendor = mapper.readValue(json, SingleVendor.class);
        repository.save(singleVendor);
    }
}
