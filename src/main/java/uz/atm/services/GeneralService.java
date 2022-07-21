package uz.atm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.atm.enums.Methods;
import uz.atm.exceptions.JsonParserException;
import uz.atm.model.General;
import uz.atm.services.methodServices.*;

import java.util.Objects;

@Service
@Slf4j
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
    private final SuccessInfoService successInfoService;
    private final ResponseClaimInfoService responseClaimInfoService;

    private final ResponseAuctionService responseAuctionService;

    private final NoResultService noResultService;

    private final RkpPaysInfoService rkpPaysInfoService;

    private final PaysByLotIdService paysByLotIdService;

    private final RkpPaysService rkpPaysService;



/*    public void parse(String str) throws JsonProcessingException {
        General general = new Gson().fromJson(str, General.class);
        if (Objects.nonNull(general.getMETHOD_NAME())) {
            String methodName = general.getMETHOD_NAME();
            if (methodName.equals(Methods.RESULTAT.toString())) {
                resultatService.save(str);
            } else if (methodName.equals(CONTRACT_INFO.toString())) {
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
            } else if (methodName.equals(Methods.SUCCESS_INFO.toString())) {
                successInfoService.save(str);
            } else if (methodName.equals(Methods.RESPONSE_CLAIM_INFO.toString())) {
                responseClaimInfoService.save(str);
            } else if (methodName.equals(Methods.RESPONSE_AUCTION.name())) {
                responseAuctionService.save(str);
            }
        } else
            manualIdentifierService.saveManualAccordingToType(str);
    }*/

    @SneakyThrows
    public void parser(String str) {

        General general = new Gson().fromJson(str, General.class);
        if (general.getMETHOD_NAME() == null) {
            general.setMETHOD_NAME("DEFAULT");
        }

        if (Objects.nonNull(general.getMETHOD_NAME())) {
            String methodName = general.getMETHOD_NAME();
            Methods methods;
            try {
                methods = Methods.valueOf(methodName);
            } catch (IllegalArgumentException e) {
                System.out.println(str);

                methods = Methods.valueOf("DEFAULT");
            }


            try {
                switch (methods) {
                    case RESULTAT -> resultatService.save(str);
                    case CONTRACT_INFO -> contractInfoService.save(str);
                    case CLAIM_INFO_ETP -> claimInfoEtpService.save(str);
                    case ERROR_INFO -> errorInfoService.save(str);
                    case FACTURA_INFO -> facturalInfoService.save(str);
                    case REQUEST_ETP -> requestEtpService.save(str);
                    case RKP_END -> rkpEndService.save(str);
                    case SUCCESS_INFO -> successInfoService.save(str);
                    case RESPONSE_CLAIM_INFO -> responseClaimInfoService.save(str);
                    case RESPONSE_AUCTION -> responseAuctionService.save(str);
                    case NO_RESULT -> noResultService.save(str);
                    case RKP_PAYS_INFO -> rkpPaysInfoService.save(str);
                    case PAYS_BY_LOTID -> paysByLotIdService.save(str);
                    case RKP_PAYS -> rkpPaysService.save(str);
                    default -> manualIdentifierService.saveManualAccordingToType(str);
                }
            } catch (JsonProcessingException e) {
                throw new JsonParserException(e.getMessage());
            }
        }
    }

}
