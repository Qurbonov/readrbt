package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import uz.atm.criteria.RequestEtpCriteria;
import uz.atm.dto.RequestEtpCollectedDto;
import uz.atm.dto.RequestEtpDto;
import uz.atm.model.requestEtp.RequestEtp;
import uz.atm.repository.RequestEtpRepository;
import uz.atm.repository.ResponseAuctionRepository;
import uz.atm.services.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@Service
public class RequestEtpService extends AbstractService<RequestEtpRepository> {

    private final ResponseAuctionRepository responseAuctionRepository;

    public RequestEtpService(RequestEtpRepository repository, ResponseAuctionRepository responseAuctionRepository) {
        super(repository);
        this.responseAuctionRepository = responseAuctionRepository;
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
                    r.getOrganName(), r.getPltf(), r.getSize(),r.getPage()
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

    public Optional<RequestEtpCollectedDto> getById(Long id) {
        RequestEtpCollectedDto collectedDto = new RequestEtpCollectedDto();
        Optional<RequestEtp> byId = repository.findById(id);
        if (byId.isPresent()) {
            RequestEtp requestEtp = byId.get();
            collectedDto.requestEtp = requestEtp;
            Long lotId = requestEtp.getPayload().getLotId();
            collectedDto.responseAuctions = responseAuctionRepository.findAllByPayload_LotId(lotId);
            return Optional.of(collectedDto);
        } else return Optional.empty();
    }
}
