package uz.atm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import uz.atm.enums.Methods;
import uz.atm.model.General;
import uz.atm.model.contactInfo.ContractInfo;
import uz.atm.model.errorInfo.ErrorInfo;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.repository.ContractInfoRepository;
import uz.atm.repository.ErrorInfoRepository;
import uz.atm.repository.ResultatMethodRepository;

@Service
public class GeneralService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final ResultatMethodRepository resultatMethodRepository;
    private final ContractInfoRepository contractInfoRepository;
    private final ErrorInfoRepository errorInfoRepository;

    public GeneralService(ResultatMethodRepository resultatMethodRepository, ContractInfoRepository contractInfoRepository, ErrorInfoRepository errorInfoRepository) {
        this.resultatMethodRepository = resultatMethodRepository;
        this.contractInfoRepository = contractInfoRepository;
        this.errorInfoRepository = errorInfoRepository;
    }

    public void parse(String str) throws JsonProcessingException {
        General general = new Gson().fromJson(str, General.class);

        String methodName = general.getMETHOD_NAME();

        if (methodName.equals(Methods.RESULTAT.toString())) {
            this.resultatMethod(str);
        } else if (methodName.equals(Methods.CONTRACT_INFO.toString())) {
            this.contractInfo(str);
        } else if (methodName.equals(Methods.ERROR_INFO.toString())) {
            this.errorInfoMethod(str);
        }
    }

    private void resultatMethod(String json) throws JsonProcessingException {
        ResultatMethod resultatMethod = mapper.readValue(json, new TypeReference<ResultatMethod>() {
        });
        ResultatMethod save = resultatMethodRepository.save(resultatMethod);
    }

    private void contractInfo(String json) throws JsonProcessingException {
        ContractInfo contractInfo = mapper.readValue(json, new TypeReference<ContractInfo>() {
        });
        ContractInfo save = contractInfoRepository.save(contractInfo);
    }

    private void errorInfoMethod(String json) throws JsonProcessingException {
        ErrorInfo errorInfo = mapper.readValue(json, new TypeReference<ErrorInfo>() {
        });
        ErrorInfo save = errorInfoRepository.save(errorInfo);
    }
}