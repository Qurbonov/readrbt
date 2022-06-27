package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.SingleVendorEnkt;
import uz.atm.repository.manualsRepo.SingleVendorEnktRepo;
import uz.atm.services.AbstractService;

@Service
public class SingleVendorEnktService extends AbstractService<SingleVendorEnktRepo> {

    public SingleVendorEnktService(SingleVendorEnktRepo repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        SingleVendorEnkt singleVendorEnkt = mapper.readValue(json, SingleVendorEnkt.class);
        repository.save(singleVendorEnkt);
    }
}
