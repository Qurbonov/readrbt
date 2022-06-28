package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import uz.atm.criteria.RequestEtpCriteria;
import uz.atm.dto.RequestEtpDto;
import uz.atm.dto.ResultatDto;
import uz.atm.model.requestEtp.RequestEtp;
import uz.atm.repository.RequestEtpRepository;
import uz.atm.services.AbstractService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class RequestEtpService extends AbstractService<RequestEtpRepository> {

    public RequestEtpService(RequestEtpRepository repository) {
        super(repository);
    }

    public void save(String json) throws JsonProcessingException {
        RequestEtp requestEtp = mapper.readValue(json, new TypeReference<RequestEtp>() {
        });
        RequestEtp save = repository.save(requestEtp);
    }

    public List<RequestEtpDto> getAllAuctionsByCriteria(RequestEtpCriteria r) {
        try {
            String json = repository.findByCriteria(
                    r.getDocDateFrom(), r.getDocDateTo(), r.getLotId(),
                    r.getMonth(), r.getSumLotTo(), r.getSumLotFrom(),
                    r.getOrganName(), r.getPltf(), r.getState()
            );
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<RequestEtpDto> requestEtpDtos = mapper.readValue(json, new TypeReference<List<RequestEtpDto>>() {
            });
            return requestEtpDtos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}
