package uz.atm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.enums.Methods;
import uz.atm.exceptions.JsonParserException;
import uz.atm.model.General;
import uz.atm.services.methodServices.*;

import java.util.Objects;

import static uz.atm.enums.Methods.CONTRACT_INFO;

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
    private final SuccessInfoService successInfoService;
    private final ResponseClaimInfoService responseClaimInfoService;

    private final ResponseAuctionService responseAuctionService;


    public void parse(String str) throws JsonProcessingException {
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
    }

    public void parser(String str) {
        General general = new Gson().fromJson(str, General.class);
        if (Objects.nonNull(general.getMETHOD_NAME())) {
            String methodName = general.getMETHOD_NAME();
            Methods methods = Methods.valueOf(methodName);
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
                    default -> manualIdentifierService.saveManualAccordingToType(str);
                }
            } catch (JsonProcessingException e) {
                throw new JsonParserException(e);
            }
        }
    }
}

/*

  "METOD_NAME":"RKP_PAYS",

  2.2.9.So'rovshartnoma fakturalari
  &ldquo;METHOD_NAME&rdquo;: &ldquo;QUERY_FACTURA&rdquo;

  2.2.10. TIN bo'yicha tashkilotlarga so'rov
  &ldquo;METHOD_NAME&rdquo;: &ldquo;QUERY_ORGAN&rdquo;

  2.2.11. TIN bo'yicha shaxsiy hisoblarni so'rash
  &ldquo;METHOD_NAME&rdquo;: &ldquo;QUERY_CLS&rdquo;

  2.2.13. Hujjatni qabul qilishni tasdiqlash
   &ldquo;METHOD_NAME&rdquo;: &ldquo;SUCCESS_HUJJATLAR&rdquo;

  2.2.15. Tashkilot kodi bo'yicha komissiya to'lovlarini talab qilish
  &ldquo;METHOD_NAME&rdquo;: &ldquo;QUERY_PAYS_COMMISSION&rdquo;,

  2.3.1. Xarid qilish rejasi
  "METOD_NAME":"REJA_MA'LUMOT",

  2.3.6. Qabul qilingan to'lov topshiriqlariga javob / ETP dan CMO
  "METOD_NAME":"RKP_PAYS_INFO"



 */