package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.SingleVendorEnkt;
import uz.atm.repository.manualsRepo.SingleVendorEnktRepo;

@Service
@RequiredArgsConstructor
public class SingleVendorEnktService {
    private final SingleVendorEnktRepo repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public void save(String json) throws JsonProcessingException {
        SingleVendorEnkt singleVendorEnkt = mapper.readValue(json, SingleVendorEnkt.class);
        repo.save(singleVendorEnkt);
    }
}
