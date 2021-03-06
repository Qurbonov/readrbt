package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.charts.EtpResultatDto;
import uz.atm.dto.methods.ResultatCollectedDto;
import uz.atm.dto.methods.ResultatDto;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.model.resultat.Specifications;
import uz.atm.model.resultat.resultatDTO.ResultatDTO;
import uz.atm.model.resultat.resultatDTO.SpecificationsDTO;
import uz.atm.repository.ContractInfoRepository;
import uz.atm.repository.ResultatMethodRepository;
import uz.atm.repository.manualsRepo.ManOrganizationsRepo;
import uz.atm.services.AbstractService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

@Service
public class ResultatService extends AbstractService<ResultatMethodRepository> {

    private final ContractInfoRepository contractInfoRepository;

    private final ModelMapper modelMapper;

    private final ManOrganizationsRepo manOrganizationsRepo;


    public ResultatService(ResultatMethodRepository repository, ContractInfoRepository contractInfoRepository, ModelMapper modelMapper, ManOrganizationsRepo manOrganizationsRepo) {
        super(repository);
        this.contractInfoRepository = contractInfoRepository;
        this.modelMapper = modelMapper;
        this.manOrganizationsRepo = manOrganizationsRepo;
    }

    public void save(String json) throws JsonProcessingException {
        try {
            ResultatMethod resultatMethod = mapper.readValue(json, new TypeReference<>() {
            });
            ResultatMethod save = repository.save(resultatMethod);
        } catch (JsonProcessingException e) {
            ResultatDTO resultatDTO = mapper.readValue(json, new TypeReference<>() {
            });
            List<Specifications> specificationsList = new LinkedList<>();

            for (SpecificationsDTO specification : resultatDTO.payloadDTO.getSpecifications()) {
                specification.setNotes(specification.getNote());
                specificationsList.add(toSPC(specification));
            }

            ResultatMethod resultatMethod = modelMapper.map(resultatDTO, ResultatMethod.class);
            resultatMethod.setPayload(modelMapper.map(resultatDTO.getPayloadDTO(), ResultatMethod.Payload.class));
            resultatMethod.getPayload().setSpecifications(specificationsList);
            ResultatMethod save = repository.save(resultatMethod);
        }
    }

    private Specifications toSPC(SpecificationsDTO sp) {
        Specifications specifications = modelMapper.map(sp, Specifications.class);
        specifications.setNote(sp.setNotes(sp.getNote()));

        return specifications;
    }

    public List<ResultatDto> getAllByCriteria(ResultatCriteria r) {
        try {
            String json = repository.findByCriteria(r.getEtpId(),
                    r.getLotId(), r.getOrganName(), r.getOrganInn(), r.getMaloy(),
                    r.getVendorInn(), r.getVendorName(), r.getContractNum(), r.getProcId(),
                    r.getFromDate(), r.getToDate(), r.getSize(), r.getPage());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.readValue(json, new TypeReference<>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Optional<ResultatCollectedDto> getById(Long id) {
        ResultatCollectedDto resultatCollectedDto = new ResultatCollectedDto();
        Optional<ResultatMethod> byId = repository.findById(id);
        if (byId.isPresent()) {
            ResultatMethod resultatMethod = byId.get();
            String organ = resultatMethod.getPayload().getOrgan();
            String organName = manOrganizationsRepo.getNameByOrgan(organ);
            resultatMethod.getPayload().setOrganName(organName);

            resultatCollectedDto.resultat = resultatMethod;
            Long lotId = resultatMethod.getPayload().getLotId();
            if (contractInfoRepository.findContractInfoByState(lotId).isPresent())
                resultatCollectedDto.contractInfo = contractInfoRepository.findContractInfoByState(lotId).get();
            else
                System.out.println("Shit is not working");
            return Optional.of(resultatCollectedDto);
        } else return Optional.empty();
    }

    public EtpResultatDto getChartInfo(Integer year) {
        EtpResultatDto resultatDto2 = new EtpResultatDto();
        String json = repository.getChartInfo(year);
        try {
            resultatDto2 = mapper.readValue(json, new TypeReference<>() {
            });
            return resultatDto2;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
