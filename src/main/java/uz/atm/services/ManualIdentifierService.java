package uz.atm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.enums.ManualValues;
import uz.atm.model.manuals.ManualIdentifier;
import uz.atm.services.manualServices.*;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ManualIdentifierService {
    private final ManAccountsService manAccountsService;
    private final ManExpGoodsService manExpGoodsService;
    private final ManOrganizationsService manOrganizationsService;
    private final SingleVendorService singleVendorService;
    private final SingleVendorEnktService singleVendorEnktService;

    public void saveManualAccordingToType(String json) throws JsonProcessingException {
        ManualIdentifier manualIdentifier = new Gson().fromJson(json, ManualIdentifier.class);
        if (Objects.nonNull(manualIdentifier.getTYPE())) {
            String type = manualIdentifier.getTYPE();
            if (ManualValues.MAN_ACCOUNTS.toString().equals(type)) {
                manAccountsService.save(json);
            } else if (ManualValues.MAN_EXPGOODS.toString().equals(type)) {
                manExpGoodsService.save(json);
            } else if (ManualValues.MAN_ORGANIZATIONS.toString().equals(type)) {
                manOrganizationsService.save(json);
            } else if (ManualValues.SINGLEVENDOR.toString().equals(type)) {
                singleVendorService.save(json);
            } else if (ManualValues.SINGLEVENDOR_ENKT.toString().equals(type)) {
                singleVendorEnktService.save(json);
            }
        }
    }
}

