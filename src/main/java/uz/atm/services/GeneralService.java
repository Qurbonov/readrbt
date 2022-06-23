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
import uz.atm.model.facturaInfo.FacturaInfo;
import uz.atm.model.requestEtp.RequestEtp;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.model.rkpEnd.RkpEnd;
import uz.atm.repository.*;

import java.util.Objects;

@Service
public class GeneralService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final ResultatMethodRepository resultatMethodRepository;
    private final ContractInfoRepository contractInfoRepository;
    private final ErrorInfoRepository errorInfoRepository;
    private final FacturalInfoRepository facturalInfoRepository;
    private final RequestEtpRepository requestEtpRepository;
    private final RkpEndRepository rkpEndRepository;

    public GeneralService(ResultatMethodRepository resultatMethodRepository, ContractInfoRepository contractInfoRepository, ErrorInfoRepository errorInfoRepository, FacturalInfoRepository facturalInfoRepository, RequestEtpRepository requestEtpRepository, RkpEndRepository rkpEndRepository) {
        this.resultatMethodRepository = resultatMethodRepository;
        this.contractInfoRepository = contractInfoRepository;
        this.errorInfoRepository = errorInfoRepository;
        this.facturalInfoRepository = facturalInfoRepository;
        this.requestEtpRepository = requestEtpRepository;
        this.rkpEndRepository = rkpEndRepository;
    }

    public void parse(String str) throws JsonProcessingException {
        General general = new Gson().fromJson(str, General.class);
        if (Objects.nonNull(general.getMETHOD_NAME())) {
            String methodName = general.getMETHOD_NAME();
           /* if (methodName.equals(Methods.RESULTAT.toString())) {
                this.resultatMethod(str);
            } else*/ if (methodName.equals(Methods.CONTRACT_INFO.toString())) {
                this.contractInfo(str);
            } else if (methodName.equals(Methods.ERROR_INFO.toString())) {
                this.errorInfoMethod(str);
            } else if (methodName.equals(Methods.FACTURA_INFO.toString())) {
                this.facturalInfomethod(str);
            } else if (methodName.equals(Methods.REQUEST_ETP.toString())) {
                this.requestEtpMethod(str);
            } else if (methodName.equals(Methods.RKP_END.toString())) {
                this.rkpEndMethod(str);
            }
        }


    }

    private void rkpEndMethod(String json) throws JsonProcessingException {
        RkpEnd rkpEnd = mapper.readValue(json, new TypeReference<RkpEnd>() {
        });
        RkpEnd save = rkpEndRepository.save(rkpEnd);
    }

    private void requestEtpMethod(String json) throws JsonProcessingException {
        RequestEtp requestEtp = mapper.readValue(json, new TypeReference<RequestEtp>() {
        });
        RequestEtp save = requestEtpRepository.save(requestEtp);
    }

    private void facturalInfomethod(String json) throws JsonProcessingException {
        FacturaInfo facturalInfo = mapper.readValue(json, new TypeReference<FacturaInfo>() {
        });
        FacturaInfo save = facturalInfoRepository.save(facturalInfo);
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