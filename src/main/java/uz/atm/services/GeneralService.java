package uz.atm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.enums.Methods;
import uz.atm.model.General;
import uz.atm.services.methodServices.*;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GeneralService {
    private final ManualIdentifierService manualIdentifierService;

    private final ResultatService resultatService;
    private final ContractInfoService contractInfoService;
    private final ErrorInfoService errorInfoService;
    private final FacturaInfoService facturalInfoService;
    private final RequestEtpService requestEtpService;
    private final RkpEndService rkpEndService;
    private final ClaimInfoEtpService claimInfoEtpService;


    public void parse(String str) throws JsonProcessingException {
        General general = new Gson().fromJson(str, General.class);
        if (Objects.nonNull(general.getMETHOD_NAME())) {
            String methodName = general.getMETHOD_NAME();
            if (methodName.equals(Methods.RESULTAT.toString())) {
                resultatService.save(str);
            } else if (methodName.equals(Methods.CONTRACT_INFO.toString())) {
                contractInfoService.save(str);
            } else if (methodName.equals(Methods.CLAIM_INFO_ETP.toString())) {
                claimInfoEtpService.save(str);
            } else if (methodName.equals(Methods.ERROR_INFO.toString())) {
                errorInfoService.save(str);
            } else if (methodName.equals(Methods.FACTURA_INFO.toString())) {
                facturalInfoService.save(str);
            } else if (methodName.equals(Methods.REQUEST_ETP.toString())) {
                requestEtpService.save(str);
            } else if (methodName.equals(Methods.RKP_END.toString())) {
                rkpEndService.save(str);
            }
        } else
            manualIdentifierService.saveManualAccordingToType(str);
    }
}