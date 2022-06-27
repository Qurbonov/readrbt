package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.SingleVendor;
import uz.atm.repository.manualsRepo.SingleVendorRepo;


@Service
@RequiredArgsConstructor
public class SingleVendorService {
    private final SingleVendorRepo repo;
    private final ObjectMapper mapper;

    public void save(String json) throws JsonProcessingException {
        SingleVendor singleVendor = mapper.readValue(json, SingleVendor.class);
        repo.save(singleVendor);
    }
}
