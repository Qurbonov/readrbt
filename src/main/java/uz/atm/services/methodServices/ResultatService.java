package uz.atm.services.methodServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.methods.ResultatCollectedDto;
import uz.atm.dto.methods.ResultatDto;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.model.resultat.Specifications;
import uz.atm.model.resultat.resultatDTO.PayloadDTO;
import uz.atm.model.resultat.resultatDTO.ResultatDTO;
import uz.atm.model.resultat.resultatDTO.SpecificationsDTO;
import uz.atm.repository.ContractInfoRepository;
import uz.atm.repository.ResultatMethodRepository;
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

    public ResultatService(ResultatMethodRepository repository, ContractInfoRepository contractInfoRepository) {
        super(repository);
        this.contractInfoRepository = contractInfoRepository;
    }

    public void save(String json) throws JsonProcessingException {
        try {
            ResultatMethod resultatMethod = mapper.readValue(json, new TypeReference<ResultatMethod>() {
            });

            System.out.println(resultatMethod.toString());

            ResultatMethod save = repository.save(resultatMethod);
        } catch (JsonProcessingException e) {
            ResultatDTO resultatDTO = mapper.readValue(json, new TypeReference<ResultatDTO>() {
            });
            List<Specifications> specificationsList = new LinkedList<>();

            for (SpecificationsDTO specification : resultatDTO.payloadDTO.getSpecifications()) {
                specification.setNotes(specification.getNote());
                specificationsList.add(toSPC(specification));
            }

            ResultatMethod resultatMethod = toRMDTO(resultatDTO);
            resultatMethod.setPayload(toPayDTO(resultatDTO.getPayloadDTO()));
            resultatMethod.getPayload().setSpecifications(specificationsList);
            ResultatMethod save = repository.save(resultatMethod);
            System.out.println(save);

        }

    }

    private ResultatMethod toRMDTO(ResultatDTO resultatDTO) {
        ResultatMethod resultatMethod = new ResultatMethod();
        resultatMethod.setMethodName(resultatDTO.getMethodName());
        resultatMethod.setEtp_id(resultatDTO.getEtp_id());

        return resultatMethod;
    }

    private ResultatMethod.Payload toPayDTO(PayloadDTO payloadDTO) {
        ResultatMethod.Payload payload = new ResultatMethod.Payload();
        payload.setLotId(payloadDTO.getLotId());
        payload.setProcId(payloadDTO.getProcId());
        payload.setLotDate1(payloadDTO.getLotDate1());
        payload.setLotDate2(payloadDTO.getLotDate2());
        payload.setContractNum(payloadDTO.getContractNum());
        payload.setContractDat(payloadDTO.getContractDat());
        payload.setDvr(payloadDTO.getDvr());
        payload.setOrgan(payloadDTO.getOrgan());
        payload.setInn(payloadDTO.getInn());
        payload.setLs(payloadDTO.getLs());
        payload.setVendorName(payloadDTO.getVendorName());
        payload.setVendorBank(payloadDTO.getVendorBank());
        payload.setVendorAcc(payloadDTO.getVendorAcc());
        payload.setVendorInn(payloadDTO.getVendorInn());
        payload.setMaloy(payloadDTO.getMaloy());
        payload.setSumma(payloadDTO.getSumma());
        payload.setSumNds(payloadDTO.getSumNds());
        payload.setSpok(payloadDTO.getSpok());
        payload.setAvans(payloadDTO.getAvans());
        payload.setAvansDay(payloadDTO.getAvansDay());
        payload.setContractBeg(payloadDTO.getContractBeg());
        payload.setContractEnd(payloadDTO.getContractEnd());
        payload.setPurpose(payloadDTO.getPurpose());
        payload.setVendorTerr(payloadDTO.getVendorTerr());
        payload.setBeneficiar(payloadDTO.getBeneficiar());
        payload.setRaschot(payloadDTO.getRaschot());
        payload.setReestrId(payloadDTO.getReestrId());
        payload.setPnfl(payloadDTO.getPnfl());
        payload.setVendorCountry(payloadDTO.getVendorCountry());
        payload.setVendorForeign(payloadDTO.getVendorForeign());
        payload.setVendorInfo(payloadDTO.getVendorInfo());
        payload.setVendorKls(payloadDTO.getVendorKls());
        payload.setGenId(payloadDTO.getGenId());
        payload.setContractId(payloadDTO.getContractId());
        payload.setVersion(payloadDTO.getVersion());
        payload.setGrafics(payloadDTO.getGrafics());
        payload.setFinsrc(payloadDTO.getFinsrc());

        return payload;
    }
    private Specifications toSPC(SpecificationsDTO sp) {

        Specifications ss = new Specifications();
        ss.setFinYear(sp.getFinYear());
        ss.setKls(sp.getKls());
        ss.setNpos(sp.getNpos());
        ss.setTovar(sp.getTovar());
        ss.setTovarName(sp.getTovarName());
        ss.setTovarNote(sp.getTovarNote());
        ss.setTovarEdizm(sp.getTovarEdizm());
        ss.setTovarAmount(sp.getTovarAmount());
        ss.setTovarPrice(sp.getTovarPrice());
        ss.setTovarSumma(sp.getTovarSumma());
        ss.setExpense(sp.getExpense());
        ss.setSplit(sp.getSplit());
        ss.setNote(sp.setNotes(sp.getNote()));
        ss.setProperties(sp.getProperties());
        return ss;
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
            resultatCollectedDto.resultat = resultatMethod;
            Long lotId = resultatMethod.getPayload().getLotId();
            resultatCollectedDto.contractInfo = contractInfoRepository.findAllByPayload_LotId(lotId);
            return Optional.of(resultatCollectedDto);
        } else return Optional.empty();
    }
}
